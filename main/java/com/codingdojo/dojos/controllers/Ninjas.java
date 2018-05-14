package com.codingdojo.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.services.DojoService;
import com.codingdojo.dojos.services.NinjaService;

@Controller
public class Ninjas {
	
	private DojoService dojoService;
	private NinjaService ninjaService;
	
	public Ninjas(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	

	
	@RequestMapping("/ninjas/new")
	public String ninja(Model model) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		model.addAttribute("ninja", new Ninja());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
		if(result.hasErrors()) {
			return "ninja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}

}
