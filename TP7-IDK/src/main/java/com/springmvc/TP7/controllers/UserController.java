package com.springmvc.TP7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.TP7.models.User;
import com.springmvc.TP7.repositoires.UserRepository;


@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/user")
	public String user(Model model){
		model.addAttribute("users",userRepository.findAll());
		return "user";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/validateLogin")
	public String validateLogin(@RequestParam String login, @RequestParam String pass) {
		
		User user = userRepository.findByLogin(login);
		if(user != null && user.getPass() == pass) {
			return "redirect:/show/" + user.getId();
		}
		else {
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		return "register";
	}
	
	@RequestMapping("/validateLogin")
	public String validateRegister(@RequestParam String login, @RequestParam String pass, 
			@RequestParam String mail, @RequestParam String ville) {
		User user = new User();
		user.setLogin(login);
		user.setMail(mail);
		user.setPass(pass);
		user.setVille(ville);
		
		userRepository.save(user);
		
		return "redirect:/show/" + user.getId();
	}
	
	
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findById(id).orElse(null));
		return "show";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Long id) {
		User user = userRepository.findById(id).orElse(null);
		userRepository.delete(user);
		return "redirect:/user";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findById(id).orElse(null));
		return "edit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Long id, @RequestParam String login, 
			@RequestParam String pass, @RequestParam String mail, @RequestParam String ville) {
		User user = userRepository.findById(id).orElse(null);
		user.setLogin(login);
		user.setMail(mail);
		user.setPass(pass);
		user.setVille(ville);
		userRepository.save(user);
		
		return "redirect:/show/" + user.getId();
	}

}
