package com.family.tree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		  exclude = {
		    org.springframework.ai.vectorstore.neo4j.autoconfigure.Neo4jVectorStoreAutoConfiguration.class
		  }
		)
		public class FamilyDataTreeApplication {
		  public static void main(String[] args) {
		    SpringApplication.run(FamilyDataTreeApplication.class, args);
		  }
		}

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class FamilyDataTreeApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(FamilyDataTreeApplication.class, args);
//	}
//
//}
