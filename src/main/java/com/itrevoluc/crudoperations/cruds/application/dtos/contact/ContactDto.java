package com.itrevoluc.crudoperations.cruds.application.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    public long idContact;
    public String name;
    public String lastName;
    public String email;
    public String phone;
    public String address;
    public String company;
    public String note;
}
