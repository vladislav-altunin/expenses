package com.vlad.expenses.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {
	
	@GetMapping("/index")
	public String returnIndex() {
		return "index";
	}
}
