package com.VehicleAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VehicleAPI.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByRegistration(String registration);
    List<Vehicle> findByPrixParJourLessThanEqual(double prix);
}

