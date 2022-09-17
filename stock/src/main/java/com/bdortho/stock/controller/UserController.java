package com.bdortho.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdortho.stock.model.UserModel;
import com.bdortho.stock.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	@GetMapping("/manage")
	public String manage(Model model, @RequestParam(required = false) Long id) {
		List<UserModel> users = userService.getAll();
		model.addAttribute("id", id);
		model.addAttribute("users", users);
		return "/home/user/manage";
	}
	
	@PostMapping("/save")
	public String save(UserModel userModel) {
		userService.save(userModel);
		return "redirect:/user/manage?id="+userModel.getId();
	}
	
	@ResponseBody
	@GetMapping("/get-by-id")
	public UserModel getById(Long id) {
		UserModel user = userService.getById(id);
		return user;
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		UserModel userModel = userService.getById(id);
		model.addAttribute("userModel", userModel);
		return "/home/user/companyCreate";
	}
	
	@PostMapping("/delete")
	public String delete(UserModel user) {
		userService.delete(user);
		return "redirect:/user/manage";
	}

}
