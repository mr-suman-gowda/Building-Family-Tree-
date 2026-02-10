package com.family.tree.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.family.tree.dtos.LandVillageProjection;
import com.family.tree.models.Land;

import java.util.List;

public interface LandRepository extends Neo4jRepository<Land, String> {

    @Query("""
        MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
		WHERE l.villageName IS NOT NULL
		RETURN
		    l.surveyNumber AS surveyNumber,
		    l.villageName AS village,
		    toFloat(COALESCE(l.acres, 0)) AS acres,
		    toFloat(COALESCE(l.gunta, 0)) AS gunta,
		    reduce(str = '', s IN l.waterSource | str + CASE WHEN str = '' THEN s ELSE ', ' + s END) AS waterSource,
		    toFloat(COALESCE(l.acres, 0)) + (toFloat(COALESCE(l.gunta, 0)) * 0.025) AS totalArea
		ORDER BY l.villageName;
        """)
    List<LandVillageProjection> fetchLandVillageSummary();

    @Query("""
        MATCH (l:LandPlot)
        WHERE l.acres IS NOT NULL OR l.gunta IS NOT NULL
        RETURN 
            sum(COALESCE(toFloat(l.acres), 0.0)) + (sum(COALESCE(toFloat(l.gunta), 0.0)) * 0.025) AS totalLandAreaInAcres
        """)
    Double getTotalLandArea();
}
