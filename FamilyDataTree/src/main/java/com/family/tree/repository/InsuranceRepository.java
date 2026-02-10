package com.family.tree.repository;

import com.family.tree.dtos.InsuranceVillageProjection;
import com.family.tree.models.Insurance;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;

public interface InsuranceRepository extends Neo4jRepository<Insurance, String> {
	
	@Query("""
		    MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
			WHERE l.villageName IS NOT NULL
			WITH 
			    l.villageName AS villageName,
			    COUNT(DISTINCT p) AS totalPersons,
			    COUNT(DISTINCT CASE WHEN p.hasHealthInsurance = 'Yes' THEN p END) AS insuredPersons,
			    SUM(CASE WHEN p.healthInsurancePremium IS NOT NULL THEN p.healthInsurancePremium ELSE 0 END) AS totalInsuranceAmount
			RETURN 
			    villageName, 
			    totalPersons, 
			    insuredPersons, 
			    totalInsuranceAmount
			ORDER BY villageName;
		""")
		List<InsuranceVillageProjection> fetchInsuranceVillageSummary();
}
