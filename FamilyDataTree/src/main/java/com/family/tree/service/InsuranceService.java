package com.family.tree.service;

import com.family.tree.dtos.InsuranceVillageProjection;
import com.family.tree.repository.InsuranceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<InsuranceVillageProjection> getInsuranceDetails() {
        return insuranceRepository.fetchInsuranceVillageSummary();
    }
}
