package com.itrevoluc.crudoperations.cruds.application.services;

import com.itrevoluc.crudoperations.cruds.application.contracts.ICarService;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.CarDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.NewCarDto;
import com.itrevoluc.crudoperations.cruds.application.mappers.CarMapper;
import com.itrevoluc.crudoperations.cruds.domain.entities.Car;
import com.itrevoluc.crudoperations.cruds.infrastructure.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository _carRepository;

    @Override
    public CarDto saveCar(NewCarDto newCarDto) {
        Car newCar = CarMapper.NewCarDtoToDb(newCarDto);
        return CarMapper.DbToCarDto(_carRepository.save(newCar));
    }

    @Override
    public List<CarDto> getCars() {
        List<Car> cars = _carRepository.findAll();
        return cars.stream().map(CarMapper::DbToCarDto).collect(Collectors.toList());
    }

    @Override
    public CarDto getCar(long idCar) {
        Car car = _carRepository.findById(idCar).stream().findFirst().orElse(null);
        if (car == null) {
            return null;
        }
        return CarMapper.DbToCarDto(car);
    }

    @Override
    public List<String> getBuilders() {

        return _carRepository.getBuilders();
    }

    @Override
    public List<CarDto> getCarsByBuilder(String builder) {
        List<Car> cars = _carRepository.getCarsByBuilder(builder);
        return cars.stream().map(CarMapper::DbToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsByYear(int year) {
        List<Car> cars = _carRepository.getCarsByYear(year);
        return cars.stream().map(CarMapper::DbToCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean updateCar(NewCarDto newCarDto, long id) {
        Car car = _carRepository.findById(id).orElse(null);
        if (car == null) {
            return false;
        }
        car = CarMapper.NewCarDtoToDb(newCarDto);
        _carRepository.save(car);
        return true;
    }
}