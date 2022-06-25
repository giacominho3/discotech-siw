package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Brano;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.BranoService;

@Controller
public class BranoController {
	
	@Autowired
	BranoService bs;
	
	@Autowired
	AutoreService as;
	
	@RequestMapping(value = "/brani", method = RequestMethod.GET)
	public String mostraListaBrani (Model model) {
		model.addAttribute("brani", this.bs.listaBrani());
		return "brani.html";
	}
	
	@RequestMapping(value = "/brani/ascT", method = RequestMethod.GET)
	public String mostraListaBraniAscT (Model model) {
		model.addAttribute("brani", this.bs.listaBraniPerNomeAsc());
		return "brani.html";
	}
	
	@RequestMapping(value = "/brani/descT", method = RequestMethod.GET)
	public String mostraListaBraniDescT (Model model) {
		model.addAttribute("brani", this.bs.listaBraniPerNomeDesc());
		return "brani.html";
	}
	
	@RequestMapping(value = "/brani/ascD", method = RequestMethod.GET)
	public String mostraListaBraniAscD (Model model) {
		model.addAttribute("brani", this.bs.listaBraniPerDataAsc());
		return "brani.html";
	}
	
	@RequestMapping(value = "/brani/descD", method = RequestMethod.GET)
	public String mostraListaBraniDescD (Model model) {
		model.addAttribute("brani", this.bs.listaBraniPerDataDesc());
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
		model.addAttribute("autori", this.as.listaAutori());
		return "nuovoBrano.html";
	}
	
	@RequestMapping(value = "/nuovoBrano", method = RequestMethod.POST)
	public String addBrano (@ModelAttribute("brano") Brano b, Model model) {
		this.bs.salva(b);
		model.addAttribute("brani", this.bs.listaBrani());
		return "brani.html";
	}
}