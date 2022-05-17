package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin (Model model) {
		return "login.html";
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String getRegistrazione (Model model) {
		return "registrazione.html";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login (Model model) {
		return "home.html";
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	public String registrazione (Model model) {
		return "home.html";
	}

}
