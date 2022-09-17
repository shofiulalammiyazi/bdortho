package com.bdortho.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StockApplicationController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("applicationName", "Stock Management");
		return "/home/main";
	}
}
