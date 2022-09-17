package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.PurchaseModel;
import com.bdortho.stock.service.PurchaseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
	
	private final PurchaseService purchaseService;
	
	@GetMapping("/create")
	public String home(Model model) {
		model.addAttribute("purchase", new PurchaseModel());
		return "/home/purchase/purchaseCreate";
	}
	
	
	@PostMapping("/save")
	public String save(PurchaseModel purchaseModel) {
		purchaseService.save(purchaseModel);
		return "redirect:/home/purchase/purchaseShow?id="+purchaseModel.getId();
	}
	
	@PostMapping("/show")
	public String show(Model model,@RequestParam(required = false) Long id) {
		
		List<PurchaseModel> purchase = purchaseService.getAll();	
		model.addAttribute("id", id);
		model.addAttribute("purchase", purchase);
		System.out.println("........................");
		return "/home/purchase/purchaseShow";
	}
	
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public PurchaseModel getById(Long id) {
		PurchaseModel purchase = purchaseService.getById(id);
		return purchase;
	}

}
