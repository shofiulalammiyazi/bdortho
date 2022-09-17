package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.VairiantModel;
import com.bdortho.stock.service.VairiantService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vairiant")
public class VairiantController {
	
	private final VairiantService vairiantService;
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<VairiantModel> Vairiant = vairiantService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("Vairiant", Vairiant);
		return "/home/vairiant/manage";
	}
	
	@PostMapping("/save")
	public String save(VairiantModel vairiantModel) {
		vairiantService.save(vairiantModel);
		return "redirect:/vairiant/manage?id="+vairiantModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public VairiantModel getById(Long id) {
		VairiantModel vairiant = vairiantService.getById(id);
		return vairiant;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		VairiantModel vairiantModel = vairiantService.getById(id);
		model.addAttribute("vairiantModel", vairiantModel);
		return "/home/vairiant/companyCreate";
	}
	
	@PostMapping("/delete")
	public String delete(VairiantModel vairiant) {
		vairiantService.delete(vairiant);
		return "redirect:/vairiant/manage";
	}

}
