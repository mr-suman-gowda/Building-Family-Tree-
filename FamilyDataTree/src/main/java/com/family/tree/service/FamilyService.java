package com.family.tree.service;

import com.family.tree.dtos.FamilyVillageProjection;
import com.family.tree.repository.FamilyRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    
    public List<FamilyVillageProjection> getFamilyDetails() {
        return familyRepository.fetchVillageFamilySummary();
    }
  
    public Integer getTotalFamily() {
    	return familyRepository.getTotalFamilys();
    }

}
