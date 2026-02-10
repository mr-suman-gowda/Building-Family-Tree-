package com.family.tree.service;

import org.springframework.stereotype.Service;

import com.family.tree.dtos.NodeRelationDTO;
import com.family.tree.repository.GraphRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class GraphService {

	private final GraphRepository repository;

    public GraphService(GraphRepository repository) {
        this.repository = repository;
    }

    public List<NodeRelationDTO> getVillageGraph(String villageName) {
        List<Map<String, Object>> data = repository.fetchVillageGraph(villageName);
        return transform(data);
    }

    public List<NodeRelationDTO> getFamilyGraph(String headAadharId) {
        List<Map<String, Object>> data = repository.fetchFamilyGraph(headAadharId);
        return transform(data);
    }

    private List<NodeRelationDTO> transform(List<Map<String, Object>> data) {
        List<NodeRelationDTO> result = new ArrayList<>();

        for (Map<String, Object> row : data) {
            String source = (String) row.get("sourceLabel");
            String target = (String) row.get("targetLabel");
            String label = (String) row.getOrDefault("relationType", "RELATED_TO");

            // Fallback handling
            if (source == null || source.isBlank()) source = "Unknown";
            if (target == null || target.isBlank()) target = "Unknown";

            result.add(new NodeRelationDTO(source, target, label, label));
        }

        return result;
    }


}
