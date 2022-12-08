package com.vlad.expenses.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
//There is already one category table (different app)
@Table(name = "expensescategory")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	//JsonIgnore prevents infinite initialization in one to many rels
	@JsonIgnore
	private List<Expense> expenses;
	
	//Constructors
	public Category() {
		
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	
	//Getters and setters
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
}
