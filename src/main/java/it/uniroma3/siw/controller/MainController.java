package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	public MainController () {
		
	}
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index (Model model) {
		return "index.html";
	}
	
	//@GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login.html";
	}
	
	//@GetMapping("/logout")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "index.html";
	}
	
	//get logged user
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home (Model model) {
		return "home.html";
	}

}