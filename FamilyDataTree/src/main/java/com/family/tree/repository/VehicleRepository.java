package com.family.tree.repository;

import com.family.tree.dtos.VehicleVillageProjection;
import com.family.tree.models.Vehicle;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface VehicleRepository extends Neo4jRepository<Vehicle, String> {

	@Query("""
		   MATCH (p:Person)-[:OWNS_LAND]->(l:LandPlot)
			MATCH (p)-[:OWNS_VEHICLE]->(v:Vehicle)
			WHERE l.villageName IS NOT NULL
			RETURN 
			    l.villageName AS villageName,
			    count(CASE WHEN toLower(v.vehicleType) = 'car' THEN 1 ELSE null END) AS car,
			    count(CASE WHEN toLower(v.vehicleType) = 'bike' THEN 1 ELSE null END) AS bike,
			    count(CASE WHEN toLower(v.vehicleType) = 'tractor' THEN 1 ELSE null END) AS tractor,
			    count(CASE WHEN toLower(v.vehicleType) = 'bus' THEN 1 ELSE null END) AS bus,
			    count(CASE WHEN toLower(v.vehicleType) = 'truck' THEN 1 ELSE null END) AS truck,
			    count(CASE WHEN NOT toLower(v.vehicleType) IN ['car','bike','tractor','bus','truck'] THEN 1 ELSE null END) AS others
			ORDER BY villageName;
		""")
		List<VehicleVillageProjection> fetchVehicleVillageSummary();

		@Query("MATCH (v:Vehicle) RETURN count(v) AS totalVehicles")
		Integer getTotalVehicles();

}
