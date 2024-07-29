package com.itrevoluc.crudoperations.cruds.application.contracts;

import com.itrevoluc.crudoperations.cruds.application.dtos.car.CarDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.NewCarDto;
import com.itrevoluc.crudoperations.cruds.infrastructure.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICarService {
    CarDto saveCar(NewCarDto newCarDto);
    List<CarDto> getCars();
    CarDto getCar(long idCar);
    List<String> getBuilders();
    List<CarDto> getCarsByBuilder(String builder);
    List<CarDto> getCarsByYear(int year);
    boolean updateCar(NewCarDto newCarDto,long id);

}
