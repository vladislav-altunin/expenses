package com.vlad.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
//For in-memory testing
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vlad.expenses.domain.CategoryRepository;
import com.vlad.expenses.domain.Expense;
import com.vlad.expenses.domain.ExpenseRepository;

@ExtendWith(SpringExtension.class)
//In-memory testing
@DataJpaTest
//Real db testing
//@SpringBootTest
public class ExpenseRepositoryTest {
	
	//In-memory testing
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Autowired
	private ExpenseRepository erepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//Delete expense
	@Test
	public void addExpense() {
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		
		//Entity manager for in-memory testing only 
		entityManager.persistAndFlush(expense);
		
		//.save() is used with a real DB
//		erepository.save(expense);
		
		erepository.deleteAll();
		assertThat(erepository.findAll()).isEmpty();
	}
	
	//Find expense by spender's name
	@Test
	public void findExpense() {
		
		//In-memory testing
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		entityManager.persistAndFlush(expense);
		assertThat(erepository.findByName("Paul Smith").get().getName()).isEqualTo("Paul Smith");
		
		//Real DB testing
		//No need to create a new object, as it is already in the DB
//		Optional<Expense> expenses = erepository.findByName("Vlad Patterson");
//		assertThat(expenses.get().getDescription()).isEqualTo("Flights to Montreal");
	}
	
	//Spender's name misspelled
	@Test
	public void spendersNameIsNotFound() {
		//In-memory testing
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		entityManager.persistAndFlush(expense);
		assertThat(erepository.findByName("Paul Smith").get().getName()).isNotEqualTo("Anna Smith");
		
		//Real DB testing
		//No need to create a new object, as it is already in the DB
//		Optional<Expense> expenses = erepository.findByName("Vlad Patterson");
//		assertThat(expenses.get().getName()).isNotEqualTo("John Smith");
	}
}
