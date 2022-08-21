package com.rx.sm.wurthserver.item.controller;

import com.rx.sm.wurthserver.item.model.ItemBean;
import com.rx.sm.wurthserver.item.model.ItemRepository;
import com.rx.sm.wurthserver.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = {"*"})
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/")
    public ResponseEntity<Message> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody ItemBean item){
        return service.save(item);
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody ItemBean item){
        return service.update(item);
    }

}
