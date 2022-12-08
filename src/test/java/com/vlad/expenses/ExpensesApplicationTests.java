package com.vlad.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vlad.expenses.web.ExpenseController;
import com.vlad.expenses.web.ExpenseRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExpensesApplicationTests {
	
	@Autowired
	private ExpenseController controller;
	
	@Autowired
	private ExpenseRestController restController;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(restController).isNotNull();
	}

}
