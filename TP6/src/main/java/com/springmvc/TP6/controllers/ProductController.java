package com.springmvc.TP6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springmvc.TP6.models.Product;
import com.springmvc.TP6.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/product")
	public String product(Model model){
		model.addAttribute("products",productRepository.findAll());
		return "product";
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "create";
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam String prodName, @RequestParam String prodDesc, 
					@RequestParam Double prodPrice, @RequestParam String prodImage ) {
		Product product = new Product();
		product.setProdDesc(prodDesc);
		product.setProdImage(prodImage);
		product.setProdName(prodName);
		product.setProdPrice(prodPrice);
		productRepository.save(product);
		
		return "redirect:/show/" + product.getId();
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("product", productRepository.findById(id).orElse(null));
		return "show";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Long id) {
		Product product = productRepository.findById(id).orElse(null);
		productRepository.delete(product);
		return "redirect:/product";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("product", productRepository.findById(id).orElse(null));
		return "edit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Long id, @RequestParam String prodName, 
			@RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
		Product product = productRepository.findById(id).orElse(null);
		product.setProdName(prodName);
		product.setProdDesc(prodDesc);
		product.setProdImage(prodImage);
		product.setProdPrice(prodPrice);
		productRepository.save(product);
		
		return "redirect:/show/" + product.getId();
	}
}

