package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.ProductModel;
import com.bdortho.stock.model.VairiantModel;
import com.bdortho.stock.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<ProductModel> products = productService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("products", products);
		return "/home/product/manage";
	}
	
	@PostMapping("/save")
	public String save(ProductModel productModel, VairiantModel vairiantModel) {
		productModel.setVairiantModel(vairiantModel);
		productService.save(productModel);
		return "redirect:/product/manage?id="+productModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public ProductModel getById(Long id) {
		ProductModel product = productService.getById(id);
		return product;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		ProductModel productModel = productService.getById(id);
		model.addAttribute("productModel", productModel);
		return "/home/product/productCreate";
	}
	
	@PostMapping("/delete")
	public String delete(ProductModel product) {
		productService.delete(product);
		return "redirect:/product/manage";
	}

}
