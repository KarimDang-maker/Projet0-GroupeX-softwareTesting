package com.VehicleAPI.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity                 // Indique que cette classe est une entité JPA (persistée en base)
@Table(name = "vehicles") // Nom de la table en base de données
@Getter                 // Lombok : génère les getters (ex: getId())
@Setter                 // Lombok : génère les setters (ex: setId())
@Builder                // Lombok : permet de créer des objets avec le pattern Builder
@NoArgsConstructor      // Lombok : constructeur sans arguments (requis par JPA)
@AllArgsConstructor     // Lombok : constructeur avec tous les arguments
public class Vehicle {

    @Id // Marque ce champ comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément pour MySQL
    private Long id;

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber; // Contrainte d'unicité en base

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "rental_price", nullable = false)
    private Double rentalPrice;
}