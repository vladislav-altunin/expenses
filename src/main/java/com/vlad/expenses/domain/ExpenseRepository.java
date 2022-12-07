package com.vlad.expenses.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExpenseRepository extends CrudRepository<Expense, Integer>{
	
	//Fetch expenses by name
	Optional<Expense> findByName(@Param("name") String name);
}
