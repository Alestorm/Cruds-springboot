package com.itrevoluc.crudoperations.cruds.application.mappers;

import com.itrevoluc.crudoperations.cruds.application.dtos.car.CarDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.NewCarDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Car;

public class CarMapper {
    public static Car NewCarDtoToDb(NewCarDto newCarDto) {
        return new Car(
                newCarDto.builder,
                newCarDto.model,
                newCarDto.year,
                newCarDto.color,
                newCarDto.plate,
                newCarDto.engineSize,
                newCarDto.fuelType,
                newCarDto.transmission,
                newCarDto.image,
                newCarDto.price
        );
    }

    public static CarDto DbToCarDto(Car car) {
        return new CarDto(
                car.getIdCar(),
                car.getBuilder(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getPlate(),
                car.getEngineSize(),
                car.getFuelType(),
                car.getTransmission(),
                car.getImage(),
                car.getPrice()
        );
    }
}
