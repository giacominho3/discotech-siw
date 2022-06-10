package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.uniroma3.siw.dto.CredenzialiRegistrationDto;
import it.uniroma3.siw.service.CredenzialiService;

@Controller
@RequestMapping("/registrazione")
public class AuthenticationController {
	
	private CredenzialiService credenzialiService;

	public AuthenticationController(CredenzialiService credenzialiService) {
		super();
		this.credenzialiService = credenzialiService;
	}
	
	@ModelAttribute("credenziali")
	public CredenzialiRegistrationDto credenzialiRegistrationDto(){
		return new CredenzialiRegistrationDto();
	}
	
	@GetMapping
	public String mostraFormRegistrazione() {
		return "registrazione";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("credenziali") CredenzialiRegistrationDto registrationDto) {
		credenzialiService.save(registrationDto);
		return "redirect:/registrazione?success";
	}
}
