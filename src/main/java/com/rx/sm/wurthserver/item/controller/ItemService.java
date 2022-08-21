package com.rx.sm.wurthserver.item.controller;

import com.rx.sm.wurthserver.item.model.ItemBean;
import com.rx.sm.wurthserver.item.model.ItemRepository;
import com.rx.sm.wurthserver.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository repository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK", false, repository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(repository.existsById(id)){
            return new ResponseEntity<>(new Message("OK", false, repository.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("NotFound", true, repository.findById(id)), HttpStatus.BAD_REQUEST);

        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(ItemBean item){
        return new ResponseEntity<>(new Message("OK", false,repository.saveAndFlush(item)),HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(ItemBean item){
        if(repository.existsById(item.getId())){
            return new ResponseEntity<>(new Message("OK", false,repository.saveAndFlush(item)),HttpStatus.OK);

        }
        return new ResponseEntity<>(new Message("NotFound", true,null), HttpStatus.BAD_REQUEST);

    }
}
