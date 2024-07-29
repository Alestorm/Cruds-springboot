package com.itrevoluc.crudoperations.cruds.application.contracts;

import com.itrevoluc.crudoperations.cruds.application.dtos.contact.ContactDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.NewContactDto;

import java.util.List;

public interface IContactService {
    ContactDto saveContact(NewContactDto newContactDto);
    ContactDto getContact(long idContact);
    List<ContactDto> getContacts();
}
