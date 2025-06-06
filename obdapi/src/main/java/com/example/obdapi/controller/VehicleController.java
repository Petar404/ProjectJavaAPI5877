package com.example.obdapi.controller;

import com.example.obdapi.model.*;
import com.example.obdapi.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obdapi/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicle));
    }

    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String vin) {
        vehicleService.deleteVehicle(vin);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{vin}/dtc-codes")
    public ResponseEntity<List<DtcCode>> getDtcCodes(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getDtcCodes(vin));
    }

    @PostMapping("/{vin}/maintenance-logs")
    public ResponseEntity<MaintenanceLog> uploadMaintenanceLog(@PathVariable String vin, @RequestBody MaintenanceLog log) {
        return ResponseEntity.ok(vehicleService.saveMaintenanceLog(vin, log));
    }

    @GetMapping("/{vin}/maintenance-logs")
    public ResponseEntity<List<MaintenanceLog>> getMaintenanceLogs(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getMaintenanceLogs(vin));
    }

    @PostMapping("/{vin}/diagnostic-logs")
    public ResponseEntity<DiagnosticLog> uploadDiagnosticLog(@PathVariable String vin, @RequestBody DiagnosticLog log) {
        return ResponseEntity.ok(vehicleService.saveDiagnosticLog(vin, log));
    }

    @GetMapping("/{vin}/diagnostic-logs")
    public ResponseEntity<List<DiagnosticLog>> getDiagnosticLogs(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getDiagnosticLogs(vin));
    }
}
//