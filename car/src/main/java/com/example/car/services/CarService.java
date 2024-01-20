package com.example.car.services;

import com.example.car.entities.Car;
import com.example.car.entities.Client;
import com.example.car.models.CarResponse;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String CLIENT_URL = "http://localhost:8888/SERVICE-CLIENT/api/client";

    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        List<Client> clients = Arrays.asList(restTemplate.getForObject(CLIENT_URL, Client[].class));
        return cars.stream().map(car -> mapToCarResponse(car, clients)).collect(Collectors.toList());
    }

    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Invalid Car Id"));
        Client client = restTemplate.getForObject(CLIENT_URL + "/" + car.getClientId(), Client.class);
        return mapToCarResponse(car, Collections.singletonList(client));
    }

    public CarResponse save(Car car) {
        Car savedCar = carRepository.save(car);
        Client client = restTemplate.getForObject(CLIENT_URL + "/" + savedCar.getClientId(), Client.class);
        return mapToCarResponse(savedCar, Collections.singletonList(client));
    }

    public CarResponse update(Long id, Car updatedCar) throws Exception {
        Car existingCar = carRepository.findById(id).orElseThrow(() -> new Exception("Invalid Car Id"));

        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setRegistrationNumber(updatedCar.getRegistrationNumber());
        existingCar.setClientId(updatedCar.getClientId());
        existingCar.setFuelType(updatedCar.getFuelType());

        existingCar.setPhotoU(updatedCar.getPhotoU());

        Car savedCar = carRepository.save(existingCar);
        Client client = restTemplate.getForObject(CLIENT_URL + "/" + savedCar.getClientId(), Client.class);
        return mapToCarResponse(savedCar, Collections.singletonList(client));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    private CarResponse mapToCarResponse(Car car, List<Client> clients) {
        Client foundClient = clients.stream()
                .filter(client -> client.getId().equals(car.getClientId()))
                .findFirst()
                .orElse(null);

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .registrationNumber(car.getRegistrationNumber())
                .model(car.getModel())
                .fuelType(car.getFuelType())
                .photoU(car.getPhotoU())
                .build();
    }

    public List<CarResponse> findByClientId(Long clientId) {
        List<Car> cars = carRepository.findByClientId(clientId);
        List<Client> clients = Arrays.asList(restTemplate.getForObject(CLIENT_URL, Client[].class));
        return cars.stream().map(car -> mapToCarResponse(car, clients)).collect(Collectors.toList());
    }

}
