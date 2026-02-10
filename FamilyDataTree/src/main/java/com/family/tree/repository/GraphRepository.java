package com.family.tree.repository;

import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GraphRepository {

	private final Neo4jClient client;

    public GraphRepository(Neo4jClient client) {
        this.client = client;
    }

    public List<Map<String, Object>> fetchVillageGraph(String villageName) {
    	String query = """
    			 MATCH (v:Village {name: $villageName})<-[:LIVES_IN]-(f:Family)<-[r1:BELONGS_TO]-(p:Person)
			OPTIONAL MATCH (p)-[r2]->(o)
			RETURN
			  coalesce(p.name, p.aadhar) AS sourceLabel,
			  coalesce(
			    o.name,
			    o.registrationNumber,
			    o.surveyNumber,
			    o.name,
			    o.headAadharId,
			    o.id,
			    toString(id(o))) AS targetLabel,
			  CASE 
			    WHEN type(r2) = 'BELONGS_TO' OR r2 IS NULL THEN coalesce(r1.relationshipWithHead, 'BELONGS_TO')
			    ELSE type(r2)
			  END AS relationType
    			""";
        return (List<Map<String, Object>>) client.query(query).bindAll(Map.of("villageName", villageName)).fetch().all();
    }

    public List<Map<String, Object>> fetchFamilyGraph(String headAadharId) {
    	String query = """
    			  MATCH (f:Family {headAadharId: $headAadharId})<-[r1:BELONGS_TO]-(p:Person)
			OPTIONAL MATCH (p)-[r2]->(o)
    			  RETURN
    			    coalesce(p.name, p.aadhar) AS sourceLabel,
    			    coalesce(
    			      o.name,
    			      o.registrationNumber,
    			      o.surveyNumber,
    			      o.name,
    			      o.headAadharId,
    			      o.id,
    			      toString(id(o))
    			    ) AS targetLabel,
    			    CASE 
			    WHEN type(r2) = 'BELONGS_TO' OR r2 IS NULL THEN coalesce(r1.relationshipWithHead, 'BELONGS_TO')
			    ELSE type(r2)
			  END AS relationType
    			""";

        return (List<Map<String, Object>>) client.query(query).bindAll(Map.of("headAadharId", headAadharId)).fetch().all();
    }
}
