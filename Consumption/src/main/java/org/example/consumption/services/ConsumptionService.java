package org.example.consumption.services;

import org.example.consumption.entities.Consumption;
import org.example.consumption.repositories.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumptionService {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    // Get all consumptions
    public List<Consumption> findAll() {
        return consumptionRepository.findAll();
    }

    // Find a consumption by its ID
    public Consumption findById(Long id) throws Exception {
        return consumptionRepository.findById(id)
                .orElseThrow(() -> new Exception("Consumption not found with id: " + id));
    }

    // Add a new consumption
    public Consumption save(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    // Update an existing consumption
    public Consumption update(Long id, Consumption updatedConsumption) throws Exception {
        Consumption consumption = consumptionRepository.findById(id)
                .orElseThrow(() -> new Exception("Consumption not found with id: " + id));

        consumption.setCarId(updatedConsumption.getCarId());
        consumption.setQuantity(updatedConsumption.getQuantity());
        consumption.setCost(updatedConsumption.getCost());
        consumption.setDate(updatedConsumption.getDate());

        return consumptionRepository.save(consumption);
    }

    // Delete a consumption
    public void delete(Long id) throws Exception {
        Consumption consumption = consumptionRepository.findById(id)
                .orElseThrow(() -> new Exception("Consumption not found with id: " + id));
        consumptionRepository.delete(consumption);
    }
}