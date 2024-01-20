package com.example.car.controllers;

import com.example.car.entities.Car;
import com.example.car.models.CarResponse;
import com.example.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponse> findAll(@RequestParam(required = false) Long clientId) {
        if (clientId != null) {
            return carService.findByClientId(clientId);
        }
        return carService.findAll();
    }


    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {
        return carService.findById(id);
    }

    @PostMapping
    public CarResponse save(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public CarResponse update(@PathVariable Long id, @RequestBody Car updatedCar) throws Exception {
        return carService.update(id, updatedCar);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
