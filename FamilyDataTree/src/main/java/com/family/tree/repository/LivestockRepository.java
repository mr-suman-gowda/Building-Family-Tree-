package com.family.tree.repository;

import com.family.tree.dtos.LivestockVillageProjection;
import com.family.tree.models.Livestock;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;

public interface LivestockRepository extends Neo4jRepository<Livestock, String> {

	@Query("""
		    MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
			WHERE l.villageName IS NOT NULL
			OPTIONAL MATCH (p)-[:HAS_LIVESTOCK]->(ls:Livestock)
			WITH 
			    l.villageName AS villageName,
			    SUM(COALESCE(toInteger(ls.cows), 0)) AS cow,
			    SUM(COALESCE(toInteger(ls.goats), 0)) AS goat,
			    SUM(COALESCE(toInteger(ls.sheeps), 0)) AS sheep,
			    SUM(COALESCE(toInteger(ls.hen), 0)) AS hen
			WITH 
			    villageName, cow, goat, sheep, hen,
			    (cow + goat + sheep + hen) AS total
			RETURN 
			    villageName, cow, goat, sheep, hen, total
			ORDER BY villageName;


		""")
		List<LivestockVillageProjection> fetchLivestockVillageSummary();

}
