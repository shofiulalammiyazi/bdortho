package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.CustomerModel;
import com.bdortho.stock.service.CustomerService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<CustomerModel> customers = customerService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("customers", customers);
		return "/home/customer/manage";
	}
	
	@PostMapping("/save")
	public String save(CustomerModel customerModel) {
		customerService.save(customerModel);
		return "redirect:/customer/manage?id="+customerModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public CustomerModel getById(Long id) {
		CustomerModel customer = customerService.getById(id);
		return customer;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		CustomerModel customerModel = customerService.getById(id);
		model.addAttribute("customerModel", customerModel);
		return "/home/customer/customerCreate";
	}
	
	@PostMapping("/delete")
	public String delete(CustomerModel customer) {
		customerService.delete(customer);
		return "redirect:/customer/manage";
	}
}
