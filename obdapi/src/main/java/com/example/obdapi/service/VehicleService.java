package com.example.obdapi.service;

import com.example.obdapi.model.*;
import com.example.obdapi.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepo;
    private final DtcCodeRepository dtcRepo;
    private final MaintenanceRepository maintenanceRepo;
    private final DiagnosticLogRepository diagnosticLogRepo;

    public VehicleService(
            VehicleRepository vehicleRepo,
            DtcCodeRepository dtcRepo,
            MaintenanceRepository maintenanceRepo,
            DiagnosticLogRepository diagnosticLogRepo
    ) {
        this.vehicleRepo = vehicleRepo;
        this.dtcRepo = dtcRepo;
        this.maintenanceRepo = maintenanceRepo;
        this.diagnosticLogRepo = diagnosticLogRepo;
    }

    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public void deleteVehicle(String vin) {
        vehicleRepo.deleteById(vin);
    }

    public List<DtcCode> getDtcCodes(String vin) {
        return dtcRepo.findByVehicle_Vin(vin);
    }

    public MaintenanceLog saveMaintenanceLog(String vin, MaintenanceLog log) {
        Vehicle vehicle = vehicleRepo.findById(vin).orElseThrow(() ->
                new IllegalArgumentException("Vehicle not found with VIN: " + vin));
        log.setVehicle(vehicle);
        return maintenanceRepo.save(log);
    }

    public List<MaintenanceLog> getMaintenanceLogs(String vin) {
        return maintenanceRepo.findByVehicle_Vin(vin);
    }

    public DiagnosticLog saveDiagnosticLog(String vin, DiagnosticLog log) {
        Vehicle vehicle = vehicleRepo.findById(vin).orElseThrow(() ->
                new IllegalArgumentException("Vehicle not found with VIN: " + vin));
        log.setVehicle(vehicle);
        return diagnosticLogRepo.save(log);
    }

    public List<DiagnosticLog> getDiagnosticLogs(String vin) {
        return diagnosticLogRepo.findByVehicle_Vin(vin);
    }
}
//