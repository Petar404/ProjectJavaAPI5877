package com.example.obdapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    private String vin;
    private String make;
    private String model;
    private int vehicleYear;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiagnosticLog> diagnosticLogs;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DtcCode> dtcCodes;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceLog> maintenanceLogs;

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return vehicleYear; }
    public void setYear(int year) { this.vehicleYear = year; }

    public List<DiagnosticLog> getDiagnosticLogs() { return diagnosticLogs; }
    public void setDiagnosticLogs(List<DiagnosticLog> diagnosticLogs) { this.diagnosticLogs = diagnosticLogs; }

    public List<DtcCode> getDtcCodes() { return dtcCodes; }
    public void setDtcCodes(List<DtcCode> dtcCodes) { this.dtcCodes = dtcCodes; }

    public List<MaintenanceLog> getMaintenanceLogs() { return maintenanceLogs; }
    public void setMaintenanceLogs(List<MaintenanceLog> maintenanceLogs) { this.maintenanceLogs = maintenanceLogs; }
}
//