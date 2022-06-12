package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepositroy;

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping("/loginValidation")
	public String loginValidation(@RequestParam String login, @RequestParam String pass, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession(false);
		if (session != null) {
			User user = userRepositroy.findByLoginAndPass(login, pass);

			if (user != null) {
				session.setAttribute("Userloged", user);
				return "redirect:/user/" + user.getIdUser();
			} else {

				return "login";
			}
		} else {

			return "redirect:/login";
		}
	}

	@RequestMapping("/userlist")
	public String userlist(Model model, HttpSession session) {
		User user = (User) session.getAttribute("Userloged");
		if (user != null) {
			model.addAttribute("users", userRepositroy.findAll());
			return "userlist";
		} else {
			session.setAttribute("root", "userlist");
			return "login";
		}
	}

	@RequestMapping("/user/{id}")
	public String user(@PathVariable Integer id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("Userloged");
		if (user != null) {
			model.addAttribute("user", userRepositroy.findById(id).orElse(null));
			return "user";
		} else {

			return "login";
		}
	}

	@RequestMapping("/register")
	public String register(Model model, HttpSession session, HttpServletRequest request) {
		User user1 = (User) session.getAttribute("Userloged");
		if (user1 != null) {
			model.addAttribute("users", userRepositroy.findAll());
			return "/";
		} else {

			return "register";
		}
	}

	@RequestMapping("/registerValidation")
	public String registerValidation(@RequestParam String login, @RequestParam String pass, @RequestParam String mail,
			@RequestParam String ville, HttpSession session) {
		User user1 = (User) session.getAttribute("Userloged");
		if (user1 == null) {
			User user = new User(login, pass, mail, ville);
			userRepositroy.save(user);
			return "redirect:/user/" + user.getIdUser();
		} else {

			return "register";
		}
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {
		User user1 = (User) session.getAttribute("Userloged");
		if (user1 != null) {
			User user = userRepositroy.findById(id).orElse(null);
			System.out.print(user);
			userRepositroy.delete(user);
			return "redirect:/userlist";
		} else {

			return "login";
		}
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("Userloged");
		if (user != null) {
			model.addAttribute("user", userRepositroy.findById(id).orElse(null));
			return "editeuser";
		} else {

			return "login";
		}
	}

	@RequestMapping("/update")
	public String update(@RequestParam Integer id, @RequestParam String login, @RequestParam String pass,
			@RequestParam String mail, @RequestParam String ville, HttpSession session, HttpServletRequest request) {
		User user1 = (User) session.getAttribute("Userloged");
		if (user1 != null) {
			User user = userRepositroy.findById(id).orElse(null);
			user.setMail(mail);
			user.setLogin(login);
			user.setPass(pass);
			user.setVille(ville);
			userRepositroy.save(user);
			return "redirect:/userlist";
		} else {

			return "login";
		}
	}

}
