package com.rx.sm.wurthserver.typeitem.controller;

import com.rx.sm.wurthserver.item.controller.ItemService;
import com.rx.sm.wurthserver.item.model.ItemBean;
import com.rx.sm.wurthserver.typeitem.model.TypeItemBean;
import com.rx.sm.wurthserver.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typeItem")
@CrossOrigin(origins = {"*"})
public class TypeItemController {
    @Autowired
    TypeItemService service;

    @GetMapping("/")
    public ResponseEntity<Message> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody TypeItemBean typeItem){
        return service.save(typeItem);
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody TypeItemBean typeItem){
        return service.update(typeItem);
    }
}
