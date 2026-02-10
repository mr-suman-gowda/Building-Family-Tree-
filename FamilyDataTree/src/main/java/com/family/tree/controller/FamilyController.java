package com.family.tree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.tree.dtos.EducationVillageProjection;
import com.family.tree.dtos.FamilyVillageProjection;
import com.family.tree.dtos.InsuranceVillageProjection;
import com.family.tree.dtos.LandVillageProjection;
import com.family.tree.dtos.LivestockVillageProjection;
import com.family.tree.dtos.NodeRelationDTO;
import com.family.tree.dtos.PersonDTO;
import com.family.tree.dtos.PersonDataDTO;
import com.family.tree.dtos.VehicleVillageProjection;
import com.family.tree.service.EducationService;
import com.family.tree.service.FamilyService;
import com.family.tree.service.GraphService;
import com.family.tree.service.InsuranceService;
import com.family.tree.service.LandService;
import com.family.tree.service.LivestockService;
import com.family.tree.service.PersonDataService;
import com.family.tree.service.PersonService;
import com.family.tree.service.VehicleService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class FamilyController {

	 private final FamilyService familyService;
	    private final VehicleService vehicleService;
	    private final EducationService educationService;
	    private final LandService landService;
	    private final InsuranceService insuranceService;
	    private final LivestockService livestockService;
	    private final PersonService personService;
	    private final PersonDataService personDataService;
	    private final GraphService service;
	    
	    @Autowired
	    public FamilyController(FamilyService familyService, 
	    		VehicleService vehicleService, 
	    		EducationService educationService, 
	    		LandService landService,
	    		InsuranceService insuranceService,
	    		LivestockService livestockService,
	    		 PersonService personService,
	    		 PersonDataService personDataService,
	    		 GraphService service) {
	        this.familyService = familyService;
	        this.vehicleService = vehicleService;
	        this.educationService = educationService;
	        this.landService = landService;
	        this.insuranceService = insuranceService;
	        this.livestockService = livestockService;
	        this.personService = personService;
	        this.personDataService = personDataService;
	        this.service = service;
	    }

	    @GetMapping("/families")
	    public List<FamilyVillageProjection> getFamilyDetails() {
	        return familyService.getFamilyDetails();
	    }
	    
	    @GetMapping("/totalFamilies")
	    public Integer getTotalFamily() {
	        return familyService.getTotalFamily();
	    }

	    @GetMapping("/vehicles")
	    public List<VehicleVillageProjection> getVehicleDetails() {
	        return vehicleService.getVehicleDetails();
	    }
	    
	    @GetMapping("/totalVehicles")
	    public Integer getTotalVehicle() {
	        return vehicleService.getTotalVehicle();
	    }
	    
	    @GetMapping("/educations")
	    public List<EducationVillageProjection> getEducationDetails() {
	        return educationService.getEducationDetails();
	    }
	    
	    @GetMapping("/lands")
	    public List<LandVillageProjection> getLandDetails() {
	        return landService.getLandDetails();
	    }
	    
	    @GetMapping("/totalLandArea")
	    public Double getTotalLandArea() {
	        return landService.getTotalLandAreas();
	    }
	    
	    @GetMapping("/insurances")
	    public List<InsuranceVillageProjection> getInsuranceDetails() {
	        return insuranceService.getInsuranceDetails();
	    }
	    
	    @GetMapping("/livestocks")
	    public List<LivestockVillageProjection> getLivestockDetails() {
	        return livestockService.getLivestockDetails();
	    }
	    
	    @GetMapping("/persons")
	    public List<PersonDTO> getAllPersons() {
	        return personService.getAllPersons();
	    }
	    
	    @GetMapping("/villagePersons")
	    public Integer getAllVillagePersons() {
	        return personService.getAllTotalPerson();
	    }
	    
	    @GetMapping("/totalPersons")
	    public Integer getAllPerson() {
	        return personService.getAllPerson();
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<String> addPerson(@RequestBody PersonDataDTO dto) {
	        personDataService.createOrUpdatePerson(dto);
	        return ResponseEntity.ok("Person data added successfully");
	    }
	    
	    @GetMapping("/villageGraph/{villageName}")
	    public List<NodeRelationDTO> getVillage(@PathVariable("villageName") String villageName) {
	        return service.getVillageGraph(villageName);
	    }

	    @GetMapping("/familyGraph/{headAadharId}")
	    public List<NodeRelationDTO> getFamily(@PathVariable("headAadharId") String headAadharId) {
	        return service.getFamilyGraph(headAadharId);
	    }
	 
}
