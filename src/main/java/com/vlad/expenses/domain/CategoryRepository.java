package com.vlad.expenses.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

	//Fetch by name
	//This method will be needed for testing purposes
	Optional<Category> findByName(@Param("name") String name);
}
