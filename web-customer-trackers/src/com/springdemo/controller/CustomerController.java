package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject dao into customers
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/home")
	public String showHomePage() {

		return "home";

	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// call get customers from service layer
		List<Customer> customerList = customerService.getCustomers();

		// add list to customer attribute
		theModel.addAttribute("customers", customerList);

		return "list-customers";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// add model attribute
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save customer using service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";

	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId,Model theModel) {
		
		//get the customer from service
		Customer theCustomer = customerService.getCustomer(customerId);
		
		//set it to model attribute and pass it to customer form
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
		
		
	}

}
