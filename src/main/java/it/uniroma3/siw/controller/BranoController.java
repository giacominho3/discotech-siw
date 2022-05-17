package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Brano;
import it.uniroma3.siw.service.BranoService;

@Controller
public class BranoController {
	
	@Autowired
	BranoService bs;
	
	@RequestMapping(value = "/brani", method = RequestMethod.GET)
	public String mostraListaBrani (Model model) {
		model.addAttribute("brani", this.bs.listaBrani());
		return "brani.html";
	}
	
	@RequestMapping(value = "/brani/{id}", method = RequestMethod.GET)
	public String getBrano (@PathVariable("id") Long id, Model model) {
		model.addAttribute("brano", this.bs.cercaId(id));
		return "brano.html";
	}
	
	@RequestMapping(value = "/nuovoBrano", method = RequestMethod.GET)
	public String formBrano (Model model) {
		model.addAttribute("brano", new Brano());
		return "nuovoBrano.html";
	}
	
	@RequestMapping(value = "/nuovoBrano", method = RequestMethod.POST)
	public String addBrano (@ModelAttribute("autore") Brano b, Model model) {
		this.bs.salva(b);
		return "brani.html";
	}
}