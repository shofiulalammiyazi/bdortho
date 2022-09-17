package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.EmployeeModel;
import com.bdortho.stock.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<EmployeeModel> employees = employeeService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("employees", employees);
		return "/home/employee/manage";
	}
	
	@PostMapping("/save")
	public String save(EmployeeModel employeeModel) {
		employeeService.save(employeeModel);
		return "redirect:/employee/manage?id="+employeeModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public EmployeeModel getById(Long id) {
		EmployeeModel employee = employeeService.getById(id);
		return employee;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		EmployeeModel employeeModel = employeeService.getById(id);
		model.addAttribute("employeeModel", employeeModel);
		return "/home/employee/employeeCreate";
	}
	
	@PostMapping("/delete")
	public String delete(EmployeeModel employee) {
		employeeService.delete(employee);
		return "redirect:/employee/manage";
	}


}
