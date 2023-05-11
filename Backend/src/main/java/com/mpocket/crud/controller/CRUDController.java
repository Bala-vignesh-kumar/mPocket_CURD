package com.mpocket.crud.controller;

import com.mpocket.crud.dto.ContactDTO;
import com.mpocket.crud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CRUDController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<?> getRecentContacts(){
        return new ResponseEntity<>(contactService.getRecentContacts(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchContacts(@RequestParam String lastName){
        return new ResponseEntity<>(contactService.searchContacts(lastName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addContacts(@RequestBody ContactDTO contactDTO){
        return new ResponseEntity<>(contactService.addContact(contactDTO), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteContact(@RequestParam Integer id){
        return new ResponseEntity<>(contactService.deleteContact(id), HttpStatus.OK);
    }

}
