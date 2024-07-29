package com.itrevoluc.crudoperations.cruds.application.mappers;

import com.itrevoluc.crudoperations.cruds.application.dtos.contact.ContactDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.contact.NewContactDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Contact;

public class ContactMapper {
    public static Contact NewContactToDb(NewContactDto newContactDto){
        return new Contact(
                newContactDto.name,
                newContactDto.lastName,
                newContactDto.email,
                newContactDto.phone,
                newContactDto.address,
                newContactDto.company,
                newContactDto.note
        );
    }
    public static ContactDto DbToContactDto(Contact contact){
        return new ContactDto(
                contact.getIdContact(),
                contact.getName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getAddress(),
                contact.getCompany(),
                contact.getNote()
        );
    }
}
