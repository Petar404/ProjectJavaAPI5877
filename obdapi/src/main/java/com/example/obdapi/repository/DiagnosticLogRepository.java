package com.example.obdapi.repository;

import com.example.obdapi.model.DiagnosticLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticLogRepository extends CrudRepository<DiagnosticLog, Long> {
    List<DiagnosticLog> findByVehicle_Vin(String vin);
}
