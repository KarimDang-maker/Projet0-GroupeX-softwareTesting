package com.VehicleAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.VehicleAPI.model.Vehicle;
import com.VehicleAPI.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public List<Vehicle> getAll() {
        return repo.findAll();
    }

    public Optional<Vehicle> getById(Long id) {
        return repo.findById(id);
    }

    public Vehicle create(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle vehicle) {
        vehicle.setId(id);
        return repo.save(vehicle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Vehicle> searchByRegistration(String reg) {
        return repo.findByRegistration(reg);
    }

    public List<Vehicle> searchByPrice(double price) {
        return repo.findByPrixParJourLessThanEqual(price);
    }
}

