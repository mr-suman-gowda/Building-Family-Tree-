//package com.family.tree.controller;
//
//import com.family.tree.dto.VehicleVillageProjection;
//import com.family.tree.service.VehicleService;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api")
//public class VehicleController {
//
//    private final VehicleService vehicleService;
//
//    public VehicleController(VehicleService vehicleService) {
//        this.vehicleService = vehicleService;
//    }
//
//    @GetMapping("/vehicles")
//    public ResponseEntity<List<VehicleVillageProjection>> getVehicleDetails() {
//        return ResponseEntity.ok(vehicleService.getVehicleDetails());
//    }
//}
