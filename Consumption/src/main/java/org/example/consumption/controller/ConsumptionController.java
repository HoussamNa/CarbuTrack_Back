package org.example.consumption.controller;

import org.example.consumption.entities.Consumption;
import org.example.consumption.services.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/consumption")
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    // Get all consumptions
    @GetMapping
    public ResponseEntity<List<Consumption>> getAllConsumptions() {
        List<Consumption> consumptions = consumptionService.findAll();
        return ResponseEntity.ok(consumptions);
    }

    // Get a single consumption by ID
    @GetMapping("/{id}")
    public ResponseEntity<Consumption> getConsumptionById(@PathVariable Long id) {
        try {
            Consumption consumption = consumptionService.findById(id);
            return ResponseEntity.ok(consumption);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new consumption
    @PostMapping
    public ResponseEntity<Consumption> createConsumption(@RequestBody Consumption consumption) {
        Consumption newConsumption = consumptionService.save(consumption);
        return ResponseEntity.ok(newConsumption);
    }

    // Update an existing consumption
    @PutMapping("/{id}")
    public ResponseEntity<Consumption> updateConsumption(@PathVariable Long id, @RequestBody Consumption consumption) {
        try {
            Consumption updatedConsumption = consumptionService.update(id, consumption);
            return ResponseEntity.ok(updatedConsumption);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a consumption
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsumption(@PathVariable Long id) {
        try {
            consumptionService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}