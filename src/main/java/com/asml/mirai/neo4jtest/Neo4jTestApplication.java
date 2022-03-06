package com.asml.mirai.neo4jtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class Neo4jTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jTestApplication.class, args);
	}

}
