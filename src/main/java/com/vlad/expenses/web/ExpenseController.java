package com.vlad.expenses.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vlad.expenses.domain.ExpenseRepository;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository erepository;
	
	@GetMapping("/index")
	public String returnIndex(Model model) {
		model.addAttribute("expenses", erepository.findAll());
		return "index";
	}
}
