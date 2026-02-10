package com.family.tree.service;

import com.family.tree.dtos.LandVillageProjection;
import com.family.tree.repository.LandRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LandService {

    private final LandRepository landRepository;

    public LandService(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    public List<LandVillageProjection> getLandDetails() {
        return landRepository.fetchLandVillageSummary();
    }
    
    public Double getTotalLandAreas() {
    	return landRepository.getTotalLandArea();
    }
}
