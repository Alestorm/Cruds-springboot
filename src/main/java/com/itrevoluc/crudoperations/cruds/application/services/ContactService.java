package com.itrevoluc.crudoperations.cruds.application.services;

import com.itrevoluc.crudoperations.cruds.application.contracts.IContactService;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.ContactDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.NewContactDto;
import com.itrevoluc.crudoperations.cruds.application.mappers.ContactMapper;
import com.itrevoluc.crudoperations.cruds.domain.entities.Contact;
import com.itrevoluc.crudoperations.cruds.infrastructure.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService implements IContactService {
    @Autowired
    private IContactRepository _contactRepository;
    @Override
    public ContactDto saveContact(NewContactDto newContactDto) {
        Contact contact = ContactMapper.NewContactToDb(newContactDto);
        var savedContact = _contactRepository.save(contact);
        return ContactMapper.DbToContactDto(savedContact);
    }
    @Override
    public ContactDto getContact(long idContact) {
        Contact contact = _contactRepository.findById(idContact).orElse(null);
        if(contact==null){
            return null;
        }
        return ContactMapper.DbToContactDto(contact);
    }
    @Override
    public List<ContactDto> getContacts() {
        List<Contact> contacts =  _contactRepository.findAll();
        return contacts.stream().map(ContactMapper::DbToContactDto).collect(Collectors.toList());
    }
}