package com.itrevoluc.crudoperations.cruds.presentation;

import com.itrevoluc.crudoperations.cruds.application.contracts.IContactService;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.ContactDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.NewContactDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private IContactService _contactService;

    @PostMapping
    public ResponseEntity<Response<ContactDto>> saveContact(@RequestBody NewContactDto newContactDto) {
        List<String> errors = new ArrayList<>();
        if(newContactDto.name.isBlank()){
            errors.add("Name cannot be empty");
        }
        if(newContactDto.name.length()<3){
            errors.add("Name has to be at least 3 characters");
        }

        var savedContact = _contactService.saveContact(newContactDto);
        return new ResponseEntity<>(Response.Success(HttpStatus.CREATED, savedContact), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<ContactDto>>> getContacts() {
        var contacts = _contactService.getContacts();
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, contacts), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ContactDto>> getContact(@PathVariable long id) {
        var contact = _contactService.getContact(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, contact), HttpStatus.OK);
    }
}
