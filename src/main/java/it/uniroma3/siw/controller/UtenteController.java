package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	UtenteService us;
	
	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
	public String mostraListaUtenti (Model model) {
		model.addAttribute("utenti", this.us.getAllUtenti());
		return "utenti.html";
	}
	
	@RequestMapping(value = "/utenti/{id}", method = RequestMethod.GET)
	public String getUtente (@PathVariable("id") Long id, Model model) {
		model.addAttribute("utente", this.us.findById(id));
		return "utente.html";
	}

}
