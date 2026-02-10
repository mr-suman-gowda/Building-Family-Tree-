package com.family.tree.service;

import com.family.tree.dtos.VehicleVillageProjection;
import com.family.tree.repository.VehicleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleVillageProjection> getVehicleDetails() {
        return vehicleRepository.fetchVehicleVillageSummary();
    }
    
    public Integer getTotalVehicle() {
    	return vehicleRepository.getTotalVehicles();
    }
}
