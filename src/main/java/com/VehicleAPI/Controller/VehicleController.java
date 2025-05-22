package com.VehicleAPI.Controller;

import jakarta.validation.Valid;
import com.VehicleAPI.Model.Vehicle;
import com.VehicleAPI.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/api/vehicles") // Base path pour tous les endpoints
@RequiredArgsConstructor // Lombok : injecte le service via le constructeur
public class VehicleController {

    private final VehicleService vehicleService;

    // ==================== Endpoints CRUD ====================

    // Créer un véhicule (POST)
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle( @RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED); // HTTP 201
    }

    // Récupérer tous les véhicules (GET)
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles); // HTTP 200
    }

    // Récupérer un véhicule par ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle); // HTTP 200
    }

    // Mettre à jour un véhicule (PUT)

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle updatedVehicle
    ) {
        Vehicle vehicle = vehicleService.updateVehicle(id, updatedVehicle);
        return ResponseEntity.ok(vehicle); // HTTP 200
    }

    // Supprimer un véhicule (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }

    // ==================== Endpoints de recherche ====================

    // Recherche par numéro d'immatriculation (GET avec paramètre)

    @PostMapping("/search/registration")
    public ResponseEntity<Vehicle> searchByRegistrationNumber(
            @RequestBody String registrationNumber
    ) {
        Vehicle vehicle = vehicleService.searchByRegistrationNumber(registrationNumber);
        return ResponseEntity.ok(vehicle); // HTTP 200
    }

    // Recherche par prix maximum (GET avec paramètre)
    @PostMapping("/search/price")
    public ResponseEntity<List<Vehicle>> searchByMaxPrice(
            @RequestBody Double maxPrice
    ) {
        List<Vehicle> vehicles = vehicleService.searchByMaxPrice(maxPrice);
        return ResponseEntity.ok(vehicles); // HTTP 200
    }
}