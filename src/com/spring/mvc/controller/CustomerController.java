package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.entity.Customer;
import com.spring.mvc.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
		@GetMapping(value = "/list")
		public String listCustomers(Model model) {
	
			List<Customer> theCustomers = customerService.getCustomers(); 
			
			model.addAttribute("customers", theCustomers);
			
			return "list-customers";
		}
		
		@GetMapping(value = "/showForm")
		public String showFormForAdd(Model model) {
			
			Customer customer = new Customer();
			
			model.addAttribute("customer", customer);
			
			return "customer-form";
		}
	
		@PostMapping(value = "/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer") Customer customer) {
			
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		}
		
		@GetMapping(value = "/updateForm")
		public String showForm(@RequestParam("customerId") int id, Model model) {
			
			Customer customer = customerService.getCustomer(id);
			model.addAttribute("customer", customer);
			
			return "customer-form";
		}
		
		@GetMapping(value = "/delete")
		public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
			
			customerService.deleteCustomer(id);
			
			return "redirect:/customer/list";
		}
}
