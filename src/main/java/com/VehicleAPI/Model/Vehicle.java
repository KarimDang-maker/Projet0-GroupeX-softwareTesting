package com.VehicleAPI.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "brand")
    private String brand;

    @Column (name = "model")
    private String model;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "type")
    private String type;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String make;

    @Column(name = "registration_number", nullable = false, unique = false)
    private String registrationNumber;

    @Column(name = "rental_price", nullable = false)
    private Double rentalPrice;
}
