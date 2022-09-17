package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.CompanyModel;
import com.bdortho.stock.service.CompanySevice;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
	
	private final CompanySevice companyService;
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<CompanyModel> companies = companyService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("companies", companies);
		return "/home/company/manage";
	}
	
	@PostMapping("/save")
	public String save(CompanyModel companyModel) {
		companyService.save(companyModel);
		return "redirect:/company/manage?id="+companyModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public CompanyModel getById(Long id) {
		CompanyModel company = companyService.getById(id);
		return company;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		CompanyModel companyModel = companyService.getById(id);
		model.addAttribute("companyModel", companyModel);
		return "/home/company/companyCreate";
	}
	
	@PostMapping("/delete")
	public String delete(CompanyModel company) {
		companyService.delete(company);
		return "redirect:/company/manage";
	}
}
