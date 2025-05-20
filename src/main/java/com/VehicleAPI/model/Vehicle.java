package com.VehicleAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String modele;
    private String registration;  // numéro d'immatriculation
    private String categorie;
    private boolean disponible;
    private double prixParJour;

    // Getters
    public Long getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getRegistration() {
        return registration;
    }

    public String getCategorie() {
        return categorie;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrixParJour() {
        return prixParJour;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrixParJour(double prixParJour) {
        this.prixParJour = prixParJour;
    }
}
