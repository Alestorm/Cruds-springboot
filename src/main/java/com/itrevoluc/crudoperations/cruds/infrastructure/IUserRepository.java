package com.itrevoluc.crudoperations.cruds.infrastructure;

import com.itrevoluc.crudoperations.cruds.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}