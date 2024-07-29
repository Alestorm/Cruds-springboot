package com.itrevoluc.crudoperations.cruds.presentation;

import com.itrevoluc.crudoperations.cruds.application.contracts.ICarService;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.CarDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.car.NewCarDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private ICarService _carService;

    @PostMapping
    public ResponseEntity<Response<CarDto>> saveCar(@RequestBody NewCarDto newCarDto) {
        return new ResponseEntity<>(Response.Success(HttpStatus.CREATED, _carService.saveCar(newCarDto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<CarDto>>> getCars() {
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, _carService.getCars()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CarDto>> getCar(@PathVariable long id) {
        CarDto carDto = _carService.getCar(id);
        if (carDto == null) {
            return new ResponseEntity<>(Response.Failure(HttpStatus.NOT_FOUND, List.of("Car not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, carDto), HttpStatus.OK);
    }

    @GetMapping("/builders")
    public ResponseEntity<Response<List<String>>> getBuilders() {
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, _carService.getBuilders()), HttpStatus.OK);
    }

    @GetMapping("/builders/search")
    public ResponseEntity<Response<List<CarDto>>> getCarsByBuilder(@RequestParam(name = "builder") String builder) {
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, _carService.getCarsByBuilder(builder)), HttpStatus.OK);
    }

    @GetMapping("/years/search")
    public ResponseEntity<Response<List<CarDto>>> getCarsOlderThanYear(@RequestParam(name = "year") int year) {
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, _carService.getCarsByYear(year)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<List<CarDto>>> updateCar(@RequestBody NewCarDto carDto, @PathVariable long id) {
        var updated = _carService.updateCar(carDto, id);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
