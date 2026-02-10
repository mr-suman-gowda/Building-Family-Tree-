package com.family.tree.service;

import com.family.tree.dtos.LivestockVillageProjection;
import com.family.tree.repository.LivestockRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivestockService {

    private final LivestockRepository livestockRepository;

    public LivestockService(LivestockRepository livestockRepository) {
        this.livestockRepository = livestockRepository;
    }

    public List<LivestockVillageProjection> getLivestockDetails() {
        return livestockRepository.fetchLivestockVillageSummary();
    }
}
