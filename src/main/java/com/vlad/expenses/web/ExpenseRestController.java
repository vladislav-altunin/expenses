package com.vlad.expenses.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vlad.expenses.domain.Category;
import com.vlad.expenses.domain.CategoryRepository;
import com.vlad.expenses.domain.Expense;
import com.vlad.expenses.domain.ExpenseRepository;

@RestController
public class ExpenseRestController {
	@Autowired
	private ExpenseRepository erepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//***EXPENSES***//
	
	//Get all expenses JSON
	@GetMapping("/expenses")
	public Iterable<Expense> getExpenses() {
		return erepository.findAll();
	}
	
	//Get expenses by amount JSON
	@GetMapping("/expenses/{name}")
	public Optional<Expense> findByName(@PathVariable("name") String name) {
		return erepository.findByName(name);
	}
	
	
	//***CATEGORIES***//
	
	//Get all categories JSON
	@GetMapping("/categories")
	public Iterable<Category> getCategories() {
		return crepository.findAll();
	}
	
	//***USERS (to be added)***//
}
