package com.itrevoluc.crudoperations.cruds.infrastructure;

import com.itrevoluc.crudoperations.cruds.domain.entities.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
    @Query("select distinct c.builder from Car c")
    List<String> getBuilders();

    @Query("select c from Car c where lower(c.builder) like lower(concat('%', :builder, '%'))")
    List<Car> getCarsByBuilder(@Param("builder") String builder);

    @Query("select c from Car c where c.year = :year")
    List<Car> getCarsByYear(@Param("year") int year);



}