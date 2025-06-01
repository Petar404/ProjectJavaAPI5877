package com.example.obdapi.repository;

import com.example.obdapi.model.MaintenanceLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceLog, Long> {
    List<MaintenanceLog> findByVehicle_Vin(String vin);
}
//