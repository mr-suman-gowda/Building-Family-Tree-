package com.family.tree.service;

import com.family.tree.dtos.EducationVillageProjection;
import com.family.tree.repository.EducationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<EducationVillageProjection> getEducationDetails() {
        return educationRepository.fetchEducationVillageSummary();
    }
}
