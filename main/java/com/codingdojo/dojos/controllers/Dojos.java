package com.codingdojo.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.services.DojoService;

@Controller
public class Dojos {
	
	private DojoService dojoService;
	
	public Dojos(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String index(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "index.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			System.out.println("Dojo created "+dojo);
			return "index.jsp";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findById(id);
		if(dojo !=null) {
			model.addAttribute("dojo", dojo);
			return "showDojo.jsp";
		}
		else {
			return "redirect:/dojos/new";
		}
	}
}
