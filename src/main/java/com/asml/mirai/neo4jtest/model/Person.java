package com.asml.mirai.neo4jtest.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class Person {

	@Id @GeneratedValue private Long id;

	private String born;
	private String name;

}