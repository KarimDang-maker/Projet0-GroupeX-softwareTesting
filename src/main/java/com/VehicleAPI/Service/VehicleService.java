package com.VehicleAPI.Service;

import com.VehicleAPI.Model.Vehicle;
import com.VehicleAPI.Repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Indique que cette classe est un service Spring
@RequiredArgsConstructor // Lombok : génère un constructeur avec les dépendances finales
public class VehicleService {

    private final VehicleRepository vehicleRepository;

//     ==================== CRUD Operations ====================

    // Créer un véhicule (avec vérification d'unicité)
    public Vehicle createVehicle(Vehicle vehicle) {
        // Vérifie si le numéro d'immatriculation existe déjà
        if (vehicleRepository.findByRegistrationNumber(vehicle.getRegistrationNumber()) != null) {
            throw new IllegalArgumentException("Registration number already exists");
        }
        return vehicleRepository.save(vehicle); // Sauvegarde en base
    }

    // Récupérer tous les véhicules
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll(); // Méthode fournie par JpaRepository
    }

    // Récupérer un véhicule par ID
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
    }

    // Mettre à jour un véhicule
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existingVehicle = getVehicleById(id); // Vérifie l'existence

        // Met à jour tous les champs sauf l'ID
        existingVehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
        existingVehicle.setMake(updatedVehicle.getMake());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setYear(updatedVehicle.getYear());
        existingVehicle.setRentalPrice(updatedVehicle.getRentalPrice());

        return vehicleRepository.save(existingVehicle); // Sauvegarde les modifications
    }

    // Supprimer un véhicule
    public void deleteVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id); // Vérifie l'existence
        vehicleRepository.delete(vehicle); // Supprime en base
    }

    // ==================== Recherches personnalisées ====================

    // Recherche par numéro d'immatriculation
    public Vehicle searchByRegistrationNumber(String registrationNumber) {
        return vehicleRepository.findByRegistrationNumber(registrationNumber);
    }

    // Recherche par prix maximum
    public List<Vehicle> searchByMaxPrice(Double maxPrice) {
        return vehicleRepository.findByRentalPriceLessThanEqual(maxPrice);
    }
}