package com.family.tree.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import com.family.tree.dtos.PersonDataDTO;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class PersonDataService {

    private final Neo4jClient neo4jClient;

	 public PersonDataService(Neo4jClient neo4jClient) {
	        this.neo4jClient = neo4jClient;
	    }
	 
	 private int parseOrZero(String str) {
		    try {
		        return str == null || str.isBlank() ? 0 : Integer.parseInt(str);
		    } catch (NumberFormatException e) {
		        return 0;
		    }
		}

    public void createOrUpdatePerson(PersonDataDTO dto) {
        // Date parsing fallback
        String dob = dto.getDob() != null ? dto.getDob().split(" ")[0] : null;

        Map<String, Object> personParams = new HashMap<>();
        personParams.put("aadhar", dto.getAadhar());
        personParams.put("name", dto.getName());
        personParams.put("gender", dto.getGender());
        personParams.put("maritalStatus", dto.getMaritalStatus());
        personParams.put("fatherName", dto.getFatherName());
        personParams.put("pan", dto.getPan());
        personParams.put("voterId", dto.getVoterId());
        personParams.put("pollingStation", dto.getPollingStation());
        personParams.put("aplStatus", dto.getAplStatus());
        personParams.put("bplStatus", dto.getBplStatus());
        personParams.put("bloodGroup", dto.getBloodGroup());
        personParams.put("mobile", dto.getMobile());
        personParams.put("dob", dob);
        personParams.put("udid", dto.getUdid());
        personParams.put("healthIssues", dto.getHealthIssues());
        personParams.put("houseStatus", dto.getHouseStatus());
        personParams.put("permanentAddress", dto.getPermanentAddress());
        personParams.put("employmentStatus", dto.getEmploymentStatus());
        personParams.put("selfemployed", dto.getSelfemployed());
        personParams.put("businessType", dto.getBusinessType());
        
        System.out.print(dto.getEmploymentStatus());
        neo4jClient.query("""
            MERGE (p:Person {aadhar: $aadhar})
            SET p.name = $name, p.gender = $gender, p.married = $maritalStatus,
                p.fatherOrHusband = $fatherName, p.pan = $pan, p.voterId = $voterId,
                p.pollNo = $pollingStation, p.apl = $aplStatus, p.bpl = $bplStatus,
                p.bloodGroup = $bloodGroup, p.mobile = $mobile, p.dob = $dob,
                p.specialUdid = $udid, p.healthIssues = $healthIssues, 
                p.houseStatus = $houseStatus, p.address = $permanentAddress,
                p.employment = $employmentStatus, p.selfEmployed = $selfemployed, 
                p.businessType = $businessType
        """).bindAll(personParams).run();
        


        // Education
        if (isNotEmpty(dto.getEducationLevel())) {
            Map<String, Object> educationParams = new HashMap<>();
            educationParams.put("aadhar", dto.getAadhar());
            educationParams.put("educationLevel", dto.getEducationLevel());
            educationParams.put("institutionName", dto.getInstitutionName());
            educationParams.put("graduated", dto.getGraduated());
            educationParams.put("institutionAddress", dto.getInstitutionAddress());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (e:Education {level: $educationLevel, institutionName: $institutionName})
                SET e.graduated = $graduated, e.institutionAddress = $institutionAddress
                MERGE (p)-[:HAS_EDUCATION]->(e)
            """).bindAll(educationParams).run();
        }


        // Vehicle
        if (isNotEmpty(dto.getVehicleType())) {
            Map<String, Object> vehicleParams = new HashMap<>();
            vehicleParams.put("aadhar", dto.getAadhar());
            vehicleParams.put("registrationNo", dto.getRegistrationNo());
            vehicleParams.put("vehicleType", dto.getVehicleType());
            vehicleParams.put("vehicleInsuranceNo", dto.getVehicleInsuranceNo());
            vehicleParams.put("vehicleInsuranceProvider", dto.getVehicleInsuranceProvider());
            vehicleParams.put("vehicleInsuranceExpiry", dto.getVehicleInsuranceExpiry());
            vehicleParams.put("insurancePremium", dto.getInsurancePremium());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (v:Vehicle {registrationNumber: $registrationNo})
                SET v.type = $vehicleType, v.name = $vehicleType,
                    v.InsuNo = $vehicleInsuranceNo, v.provider = $vehicleInsuranceProvider,
                    v.Expdate = $vehicleInsuranceExpiry, v.premium = $insurancePremium
                MERGE (p)-[:OWNS_VEHICLE]->(v)
            """).bindAll(vehicleParams).run();
        }


        // Insurance
        if ("Yes".equalsIgnoreCase(dto.getHasHealthInsurance())) {
            Map<String, Object> insuranceParams = new HashMap<>();
            insuranceParams.put("aadhar", dto.getAadhar());
            insuranceParams.put("insurer", dto.getHealthInsurer());
            insuranceParams.put("premium", dto.getInsuranceAmount());
            insuranceParams.put("healthIssues", dto.getHealthIssues());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (hi:Insurance {insurer: $insurer})
                SET hi.premium = toInteger($premium), hi.hissues = $healthIssues
                MERGE (p)-[:HAS_HEALTH_INSURANCE]->(hi)
            """).bindAll(insuranceParams).run();
        }


        // Land
        if (isNotEmpty(dto.getLandServeyNo())) {
        	Map<String, Object> landParams = new HashMap<>();
        	landParams.put("aadhar", dto.getAadhar());
        	landParams.put("landServeyNo", dto.getLandServeyNo());
        	landParams.put("landVillageName", dto.getLandVillageName());
        	landParams.put("acres", dto.getAcres());
        	landParams.put("gunta", dto.getGunta());
        	landParams.put("waterSource", dto.getWaterSource());
        	neo4jClient.query("""
        		    MATCH (p:Person {aadhar: $aadhar})
        		    MERGE (l:Land {surveyNumber: $landServeyNo})
        		    SET l.village = $landVillageName, l.acres = toFloat($acres),
        		        l.gunta = toInteger($gunta), l.waterSource = $waterSource
        		    MERGE (p)-[:OWNS_LAND]->(l)
        		""").bindAll(landParams).run();
        }

            // Crop
        if (isNotEmpty(dto.getCropName())) {
            Map<String, Object> cropParams = new HashMap<>();
            cropParams.put("landServeyNo", dto.getLandServeyNo());
            cropParams.put("cropName", dto.getCropName());
            cropParams.put("fishery", dto.getFishery());
            cropParams.put("silkWorm", dto.getSilkWorm());
            cropParams.put("cropInsurance", dto.getCropInsurance());

            neo4jClient.query("""
                MATCH (l:Land {surveyNumber: $landServeyNo})
                MERGE (c:Crop {name: $cropName})
                SET c.fishery = $fishery, c.silkWorm = $silkWorm,
                    c.cropInsurance = $cropInsurance
                MERGE (l)-[:GROWS]->(c)
            """).bindAll(cropParams).run();
        }


            // Fertilizers
        if (isNotEmpty(dto.getFertilizers())) {
            Map<String, Object> fertilizerParams = new HashMap<>();
            fertilizerParams.put("landServeyNo", dto.getLandServeyNo());
            fertilizerParams.put("fertilizers", dto.getFertilizers());

            neo4jClient.query("""
                MATCH (l:Land {surveyNumber: $landServeyNo})
                MERGE (f:Fertilizer {name: $fertilizers})
                MERGE (l)-[:USES_FERTILIZER]->(f)
            """).bindAll(fertilizerParams).run();
        }

        

        // Tools
        if (isNotEmpty(dto.getTools())) {
            Map<String, Object> toolParams = new HashMap<>();
            toolParams.put("aadhar", dto.getAadhar());
            toolParams.put("tools", dto.getTools());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (t:Tool {name: $tools})
                MERGE (p)-[:USES_TOOL]->(t)
            """).bindAll(toolParams).run();
        }


        // Livestock
        if (anyPositive(dto.getCows(), dto.getGoats(), dto.getSheeps(), dto.getHen())) {
            Map<String, Object> livestockParams = new HashMap<>();
            livestockParams.put("aadhar", dto.getAadhar());
            livestockParams.put("cows", parseOrZero(dto.getCows()));
            livestockParams.put("goats", parseOrZero(dto.getGoats()));
            livestockParams.put("sheeps", parseOrZero(dto.getSheeps()));
            livestockParams.put("hen", parseOrZero(dto.getHen()));

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (ls:Livestock { type: "Livestock", cows: toInteger($cows),
                    goats: toInteger($goats), sheeps: toInteger($sheeps), hen: toInteger($hen)})
                MERGE (p)-[:HAS_LIVESTOCK]->(ls)
            """).bindAll(livestockParams).run();
        }


        // Loan
        if (isNotEmpty(dto.getMembershipType())) {
            Map<String, Object> membershipParams = new HashMap<>();
            membershipParams.put("aadhar", dto.getAadhar());
            membershipParams.put("membershipType", dto.getMembershipType());
            membershipParams.put("loanAmount", dto.getLoanAmount());
            membershipParams.put("loanFrequency", dto.getLoanFrequency());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (m:Membership {type: $membershipType})
                SET m.loanAmount = toInteger($loanAmount), m.loanFrequency = $loanFrequency
                MERGE (p)-[:HAS_MEMBERSHIP]->(m)
            """).bindAll(membershipParams).run();
        }


     // Use a default value for 'isHead'
        String isHead = dto.getIshead() != null ? dto.getIshead() : "No";
        System.out.print(isHead);
        
        if ("Yes".equalsIgnoreCase(isHead)) {
            Map<String, Object> headFamilyParams = new HashMap<>();
            headFamilyParams.put("aadhar", dto.getAadhar());
            headFamilyParams.put("headId", dto.getHeadAadharId());
            headFamilyParams.put("familyBleow18", dto.getFamilyBleow18());
            headFamilyParams.put("familyAbove18", dto.getFamilyAbove18());
            headFamilyParams.put("isHead", isHead);

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (fam:Family {headID: $headId})
                SET fam.total_0_18 = toInteger($familyBleow18), fam.total_18_plus = toInteger($familyAbove18)
                MERGE (p)-[:BELONGS_TO]->(fam)
                SET fam.headName = p.name
                MERGE (p)-[:IS_HEAD_OF]->(fam)
            """).bindAll(headFamilyParams).run();

        }  else {
            Map<String, Object> familyParams = new HashMap<>();
            familyParams.put("aadhar", dto.getAadhar());
            familyParams.put("headId", dto.getHeadAadharId());
            familyParams.put("familyBleow18", dto.getFamilyBleow18());
            familyParams.put("familyAbove18", dto.getFamilyAbove18());

            neo4jClient.query("""
                MATCH (p:Person {aadhar: $aadhar})
                MERGE (fam:Family {headID: $headId})
                ON CREATE SET fam.total_0_18 = toInteger($familyBleow18), fam.total_18_plus = toInteger($familyAbove18)
                MERGE (p)-[:BELONGS_TO]->(fam)
                
                WITH fam
                WHERE fam.headName IS NULL
                MATCH (head:Person {aadhar: $headId})
                SET fam.headName = head.name
            """).bindAll(familyParams).run();
        }

//
//        if (isNotEmpty(dto.getAadhar()) && isNotEmpty(dto.getFamilyAbove18()) && isNotEmpty(dto.getFamilyBleow18())) {
//            Map<String, Object> familyParams = new HashMap<>();
//            familyParams.put("aadhar", dto.getAadhar());
//            familyParams.put("headId", dto.getIshead().equalsIgnoreCase("Yes") ? dto.getAadhar() : dto.getHeadAadharId());
//            familyParams.put("familyBleow18", dto.getFamilyBleow18());
//            familyParams.put("familyAbove18", dto.getFamilyAbove18());
//            familyParams.put("isHead", dto.getIshead());
//
//            // Step 1: Create or link person to family
//            neo4jClient.query("""
//                MATCH (p:Person {aadhar: $aadhar})
//                MERGE (fam:Family {headID: $headId})
//                SET fam.total_0_18 = toInteger($familyBleow18), fam.total_18_plus = toInteger($familyAbove18)
//                MERGE (p)-[:BELONGS_TO]->(fam)
//            """).bindAll(familyParams).run();
//
//            // Step 2: If this person is the head, set the family head name
//            if ("Yes".equalsIgnoreCase(dto.getIshead())) {
//                neo4jClient.query("""
//                    MATCH (p:Person {aadhar: $aadhar})
//                    MATCH (fam:Family {headID: $headId})
//                    SET fam.headName = p.name
//                    MERGE (p)-[:IS_HEAD_OF]->(fam)
//                """).bindAll(familyParams).run();
//            } else {
//                // Step 3: For non-heads, set head name if it's still missing
//                neo4jClient.query("""
//                    MATCH (f:Family {headID: $headId})
//                    WHERE f.headName IS NULL
//                    MATCH (head:Person {aadhar: $headId})
//                    SET f.headName = head.name
//                """).bindAll(familyParams).run();
//            }
//        }
////
//        // Family
//        if ("Yes".equalsIgnoreCase(dto.getIshead())) {
//            Map<String, Object> headFamilyParams = new HashMap<>();
//            headFamilyParams.put("aadhar", dto.getAadhar());
//            headFamilyParams.put("headId", dto.getAadhar());
//            headFamilyParams.put("familyBleow18", dto.getFamilyBleow18());
//            headFamilyParams.put("familyAbove18", dto.getFamilyAbove18());
//            headFamilyParams.put("isHead", dto.getIshead());
//
//            neo4jClient.query("""
//                MATCH (p:Person {aadhar: $aadhar})
//                MERGE (fam:Family {headID: $headId})
//                SET fam.total_0_18 = toInteger($familyBleow18), fam.total_18_plus = toInteger($familyAbove18)
//                MERGE (p)-[:BELONGS_TO]->(fam)
//                SET fam.headName = p.name
//                MERGE (p)-[:IS_HEAD_OF]->(fam)
//            """).bindAll(headFamilyParams).run();
//
//        } else if (isNotEmpty(dto.getFamilyBleow18()) && isNotEmpty(dto.getFamilyAbove18())) {
//            Map<String, Object> familyParams = new HashMap<>();
//            familyParams.put("aadhar", dto.getAadhar());
//            familyParams.put("familyBleow18", dto.getFamilyBleow18());
//            familyParams.put("familyAbove18", dto.getFamilyAbove18());
//
//            neo4jClient.query("""
//                MATCH (p:Person {aadhar: $aadhar})
//                MERGE (fam:Family {total_0_18: toInteger($familyBleow18), total_18_plus: toInteger($familyAbove18)})
//                MERGE (p)-[:BELONGS_TO]->(fam)
//            """).bindAll(familyParams).run();
//        }


    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    private boolean anyPositive(String... values) {
        return Arrays.stream(values).anyMatch(v -> {
            try {
                return Integer.parseInt(v) > 0;
            } catch (Exception e) {
                return false;
            }
        });
    }
}
