package com.itrevoluc.crudoperations.cruds.infrastructure;

import com.itrevoluc.crudoperations.cruds.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IContactRepository extends JpaRepository<Contact,Long> {
}
