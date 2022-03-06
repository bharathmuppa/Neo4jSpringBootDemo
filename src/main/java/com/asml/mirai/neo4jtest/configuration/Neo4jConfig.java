package com.asml.mirai.neo4jtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;

@Configuration
public class Neo4jConfig {

	@Bean("ActiveDB")
	DatabaseSelectionProvider activeDatabaseSelectionProvider() {
		return () -> DatabaseSelection.byName("neo4j");
	}

}