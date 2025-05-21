package com.VehicleAPI.Repository;

import com.VehicleAPI.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Recherche par numéro d'immatriculation
    Vehicle findByRegistrationNumber(String registrationNumber);

    // Recherche par prix maximum
    List<Vehicle> findByRentalPriceLessThanEqual(Double maxPrice);
}