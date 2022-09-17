package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.VendorModel;
import com.bdortho.stock.service.VendorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vendor")
public class VendorController {
	
	private final VendorService vendorService;
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<VendorModel> vendor = vendorService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("vendor", vendor);
		return "/home/vendor/manage";
	}
	
	@PostMapping("/save")
	public String save(VendorModel vendorModel) {
		vendorService.save(vendorModel);
		return "redirect:/vendor/manage?id="+vendorModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public VendorModel getById(Long id) {
		VendorModel vendor = vendorService.getById(id);
		return vendor;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		VendorModel vendorModel = vendorService.getById(id);
		model.addAttribute("vendorModel", vendorModel);
		return "/home/vendor/companyCreate";
	}
	
	@PostMapping("/delete")
	public String delete(VendorModel vendor) {
		vendorService.delete(vendor);
		return "redirect:/vendor/manage";
	}


}
