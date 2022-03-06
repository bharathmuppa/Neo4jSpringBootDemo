package com.asml.mirai.neo4jtest.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node("Movie")
public class Movie {

	@Id
	private final String title;

	@Property("tagline")
	private final String description;

	@Relationship(type = "ACTED_IN", direction = Direction.INCOMING)
	private List<Roles> actorsAndRoles;

	@Relationship(type = "DIRECTED", direction = Direction.INCOMING) private List<Person> directors = new ArrayList<>();

	public Movie(String title, String description) {
		this.title = title;
		this.description = description;
	}

}
