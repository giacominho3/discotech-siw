package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	//get logged user
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home (Model model) {
		return "home.html";
	}

}