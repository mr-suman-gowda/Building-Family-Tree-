package com.family.tree.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.family.tree.dtos.FamilyVillageProjection;
import com.family.tree.models.Family;

import java.util.List;

public interface FamilyRepository extends Neo4jRepository<Family, String> {

	@Query("""
		    MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
			WHERE l.villageName IS NOT NULL AND p.dob IS NOT NULL
			WITH 
			    l.villageName AS villageName, 
			    date().year - toInteger(split(p.dob, "-")[0]) AS age
			RETURN 
			    villageName,
			    count(CASE WHEN age < 18 THEN 1 END) AS total_0_18,
			    count(CASE WHEN age >= 18 THEN 1 END) AS total_18_plus,
			    count(*) AS totalMembers
			ORDER BY villageName;

		""")
		List<FamilyVillageProjection> fetchVillageFamilySummary();

		@Query("MATCH (f:Family) RETURN count(f) AS totalFamilies")
		Integer getTotalFamilys();
}