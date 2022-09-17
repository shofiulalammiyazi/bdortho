package com.bdortho.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdortho.stock.model.DemoModel;
import com.bdortho.stock.service.DemoModelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/demo-model")
public class DemoController {
	
	private final DemoModelService demoModelService;

	@GetMapping("/create")
	public String create(Model model) {
		DemoModel demoModel = new DemoModel();
		model.addAttribute("demoModel", demoModel);
		return "demo_model/create";
	}
	
	@PostMapping("/save")
	public String save(DemoModel demoModel) {
		demoModelService.save(demoModel);
		
		System.out.println("+++++++++++++++++++++----------");
		return "redirect:/demo-model/show?id="+demoModel.getId();
	}
	
	@GetMapping("/show")
	public String show(Model model, Long id) {
		DemoModel demoModel = demoModelService.getById(id);
		System.out.println("+++++++++++++++++++++");
		model.addAttribute("demoModel", demoModel);
		return "demo_model/show";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		DemoModel demoModel = demoModelService.getById(id);
		model.addAttribute("demoModel", demoModel);
		return "demo_model/create";
	}
}
