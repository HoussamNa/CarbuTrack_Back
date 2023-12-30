package com.example.car.models;

import com.example.car.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber; // Renamed from "matricue"
    private Client client;
    private String fuelType; // Added fuelType field
}
