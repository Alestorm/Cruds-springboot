package com.itrevoluc.crudoperations.cruds.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long idCar;

    private String builder;

    private String model;

    private int year;

    private String color;

    private String plate;

    @Column(name = "engine_size")
    private double engineSize;

    @Column(name = "fuel_type")
    private String fuelType;

    private String transmission;

    @Column(length = 2083)
    private String image;

    private double price;

    public Car(String builder, String model, int year, String color, String plate, double engineSize, String fuelType, String transmission, String image,double price) {
        this.builder = builder;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plate = plate;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.image = image;
        this.price = price;
    }
}
