package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.DesignationModel;
import com.bdortho.stock.service.DesignationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/designation")
public class DesignationController {
	
	private final DesignationService designationService;
		
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<DesignationModel> designations = designationService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("designations", designations);
		return "/home/designation/manage";
	}
	
	@PostMapping("/save")
	public String save(DesignationModel designationModel) {
		designationService.save(designationModel);
		return "redirect:/designation/manage?id="+designationModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public DesignationModel getById(Long id) {
		DesignationModel designation = designationService.getById(id);
		return designation;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		DesignationModel designation = designationService.getById(id);
		model.addAttribute("designation", designation);
		return "/home/designation/designationCreate";
	}
	
	@PostMapping("/delete")
	public String delete(DesignationModel designation) {
		designationService.delete(designation);
		return "redirect:/designation/manage";
	}


}
