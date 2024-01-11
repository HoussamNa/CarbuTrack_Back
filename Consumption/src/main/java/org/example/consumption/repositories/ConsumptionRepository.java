package org.example.consumption.repositories;

import org.example.consumption.entities.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> { }
