package com.asml.mirai.neo4jtest.repository;

import com.asml.mirai.neo4jtest.model.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface MovieRepository extends ReactiveNeo4jRepository<Movie, String> {

	Mono<Movie> findOneByTitle(String title);
}
