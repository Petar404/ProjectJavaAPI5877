package com.example.obdapi.model;

import jakarta.persistence.*;

@Entity
public class DiagnosticLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rawData;

    @ManyToOne
    @JoinColumn(name = "vehicle_vin", nullable = false)
    private Vehicle vehicle;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRawData() { return rawData; }
    public void setRawData(String rawData) { this.rawData = rawData; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
