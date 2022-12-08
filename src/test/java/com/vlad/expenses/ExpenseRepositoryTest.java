package com.vlad.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vlad.expenses.domain.CategoryRepository;
import com.vlad.expenses.domain.Expense;
import com.vlad.expenses.domain.ExpenseRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ExpenseRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	
	@Autowired
	private ExpenseRepository erepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//Add expense
	@Test
	public void addExpense() {
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		entityManager.persistAndFlush(expense);
		erepository.deleteAll();
		assertThat(erepository.findAll()).isEmpty();
	}
	
	//Find expense by spender's name
	@Test
	public void findExpense() {
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		entityManager.persistAndFlush(expense);
		assertThat(erepository.findByName("Paul Smith").get().getName()).isEqualTo("Paul Smith");
	}
	
	//Spender's name misspelled
	@Test
	public void spendersNameIsNotFound() {
		Expense expense = new Expense("Paul Smith", crepository.findByName("Travel").get(), "Accomodation", 500);
		entityManager.persistAndFlush(expense);
		assertThat(erepository.findByName("Paul Smith").get().getName()).isNotEqualTo("Anna Smith");
	}
}
