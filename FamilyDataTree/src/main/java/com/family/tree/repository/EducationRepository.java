package com.family.tree.repository;

import com.family.tree.dtos.EducationVillageProjection;
import com.family.tree.models.Education;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EducationRepository extends Neo4jRepository<Education, String> {

    @Query("""
		       MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
			OPTIONAL MATCH (p)-[:STUDIED_AT]->(e:Institution)
			WHERE l.villageName IS NOT NULL
			WITH 
			    l.villageName AS villageName,
			    COUNT(CASE WHEN p.graduated = 'Yes' THEN 1 ELSE NULL END) AS graduated,
			    COUNT(CASE WHEN p.graduated <> 'Yes' AND e.name IS NULL THEN 1 ELSE NULL END) AS illiterate,
			    COUNT(CASE WHEN p.graduated <> 'Yes' AND e.name IS NOT NULL THEN 1 ELSE NULL END) AS studying,
			    COUNT(DISTINCT e.name) AS educationFacility
			RETURN villageName, graduated, studying, illiterate, educationFacility
			ORDER BY villageName;
    """)
    List<EducationVillageProjection> fetchEducationVillageSummary();
}
