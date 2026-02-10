package com.family.tree.repository;

import com.family.tree.dtos.PersonDTO;
import com.family.tree.models.Person;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {

	@Query("""
		   MATCH (p:Person)
			OPTIONAL MATCH (p)-[:OWNS_LAND]->(l:LandPlot)
			OPTIONAL MATCH (p)-[:STUDIED_AT]->(e:Institution)
			OPTIONAL MATCH (p)-[:BELONGS_TO]->(f:Family)
			WITH 
			    p.name AS name,
			    p.aadhar AS aadharId,
			    p.gender AS gender,
			    p.mobile AS mobile,
			    p.dob AS dob,
			    COALESCE(e.educationLevel, 'Not Specified') AS education,
			    COALESCE(p.employment, 'Unemployed') AS employment,
			    f.address AS address
			RETURN 
			    name, 
			    aadharId, 
			    gender, 
			    mobile, 
			    dob, 
			    education, 
			    employment, 
			    address
			ORDER BY name;

		""")
		List<PersonDTO> fetchAllPersons();

		@Query("MATCH (p:Person) RETURN count(p) AS totalPersons")
		Integer getTotalPerson();  
}
