package com.itrevoluc.crudoperations.cruds.application.dtos.car;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NewCarDto {
    public String builder;
    public String model;
    public int year;
    public String color;
    public String plate;
    public double engineSize;
    public String fuelType;
    public String transmission;
    public String image;
    public double price;
}