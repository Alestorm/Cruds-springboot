package com.itrevoluc.crudoperations.cruds.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private long idContact;

    @Column(length = 50)
    private String name;

    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 23)
    private String phone;

    private String address;

    private String company;

    @Column(length = 1000)
    private String note;

    public Contact(String name, String lastName, String email, String phone, String address, String company, String note) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.company = company;
        this.note = note;
    }
}