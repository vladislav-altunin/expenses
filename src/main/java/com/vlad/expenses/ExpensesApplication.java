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
import com.vlad.expenses.domain.User;
import com.vlad.expenses.domain.UserRepository;

@SpringBootApplication
public class ExpensesApplication {
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private ExpenseRepository erepository;
	
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			//***CATEGORIES***//
			
			//Some categories created
			Category cat1 = new Category("Groceries");
			Category cat2 = new Category("Travel");
			Category cat3 = new Category("Entertainment");
			//And saved
			crepository.save(cat1);
			crepository.save(cat2);
			crepository.save(cat3);
			
			//***EXPENSES***//
			
			//Some expenses created
			Expense line1 = new Expense("Vlad Patterson", cat2, "Flights to Montreal", 900);
			Expense line2 = new Expense("Elina Shatova", cat1, "Food for one week", 100);
			//And saved
			erepository.save(line1);
			erepository.save(line2);
			
			//***USERS***//
			
			//Some users created
			//Password for all user names is: "password"
			User user0 = new User("user0", "$2a$10$lJOUlrVmavRbOS7nMk0WAOYo8NG.0G75pvz7GWuYBWreakW1BQq8G", "user0@mail.com", "ADMIN");
			User user1 = new User("user1", "$2a$10$a4pTKKR/jdUukUc8kw/oUec0WXD78FZ3Rf9iMKobXMpS/8v1XJQ0i", "user1@mail.com", "USER");
			User user2 = new User("user2", "$2a$10$2q3E1Nc3ZBIGRqvb0VD0b.ih3.0rPUkujQPzjYg.K5FFdzsDS4A6e", "user2@mail.com", "USER");
			User user3 = new User("user3", "$2a$10$T4Xv78XDeduJMs7IOpBcGe8QCrIZE.hoqHzwVYrGh/QIpxGC8zUui", "user3@mail.com", "USER");
			User user4 = new User("user4", "$2a$10$pn4NpsdQxHJY4CVrYyv4geYlen1NYQxYYHLhXKcyH37MF2OT6gWju", "user4@mail.com", "USER");
			

		};
	}

}
