package com.vlad.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vlad.expenses.domain.Category;
import com.vlad.expenses.domain.CategoryRepository;
import com.vlad.expenses.domain.Expense;
import com.vlad.expenses.domain.ExpenseRepository;

@SpringBootApplication
public class ExpensesApplication {
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private ExpenseRepository erepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			Category cat1 = new Category("Groceries");
			Category cat2 = new Category("Travel");
			Category cat3 = new Category("Entertainment");

			crepository.save(cat1);
			crepository.save(cat2);
			crepository.save(cat3);
			
			Expense line1 = new Expense("Vlad Patterson", cat2, "Flights to Montreal", 900);
			Expense line2 = new Expense("Elina Shatova", cat1, "Food for one week", 100);
			erepository.save(line1);
			erepository.save(line2);

		};
	}

}
