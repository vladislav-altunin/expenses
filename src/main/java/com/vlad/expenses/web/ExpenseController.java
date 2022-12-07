package com.vlad.expenses.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vlad.expenses.domain.CategoryRepository;
import com.vlad.expenses.domain.Expense;
import com.vlad.expenses.domain.ExpenseRepository;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository erepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/index")
	public String returnIndex(Model model) {
		model.addAttribute("expenses", erepository.findAll());
		return "index";
	}
	
	@GetMapping("/add-expense")
	public String returnAddexpense(Model model) {
		model.addAttribute("newExpense", new Expense());
		model.addAttribute("categories", crepository.findAll());
		return "addexpense";
	}
	 //POST method is used to save items
	@PostMapping("/save-expense")
	public String saveExpenseAndRedirectToIndex(@ModelAttribute Expense newExpense) {
		erepository.save(newExpense);
		return "redirect:/index";
	}
	
	//GET method is used to delete items
	@GetMapping("/delete-expense/{id}")
	public String deleteExpenseAndRedirectToIndex(@PathVariable("id") Integer id) {
		erepository.deleteById(id);
		return "redirect:/index";
	}
	
	//GET method is used to retrieve items
	//The name of the attribute is "newExpense", to match it with
	// the saveExpenseAndRedirectToIndex() method's model attribute name,
	// as this method will be used to update the line in the DB
	@GetMapping("/edit-expense/{id}")
	public String retrieveExpenseAndReturnEditExpense(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("newExpense", erepository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editexpense";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
