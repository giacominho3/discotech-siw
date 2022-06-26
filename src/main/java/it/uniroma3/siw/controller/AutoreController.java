package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.service.AutoreService;

@Controller
public class AutoreController {
	
	@Autowired
	AutoreService as;
	
	@RequestMapping(value = "/autori", method = RequestMethod.GET)
	public String mostraListaAutori (Model model) {
		model.addAttribute("autori", this.as.listaAutori());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/ascC", method = RequestMethod.GET)
	public String mostraListaAutoriAscC (Model model) {
		model.addAttribute("autori", this.as.listaPerCognomeAsc());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/descC", method = RequestMethod.GET)
	public String mostraListaAutoriDescC (Model model) {
		model.addAttribute("autori", this.as.listaPerCognomeDesc());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/ascN", method = RequestMethod.GET)
	public String mostraListaAutoriAsN (Model model) {
		model.addAttribute("autori", this.as.listaPerNazionalitaAsc());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/descN", method = RequestMethod.GET)
	public String mostraListaAutoriDescN (Model model) {
		model.addAttribute("autori", this.as.listaPerNazionalitaDesc());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/{id}", method = RequestMethod.GET)
	public String getAutore (@PathVariable("id") Long id, Model model) {
		model.addAttribute("autore", this.as.cercaId(id));
		return "autore.html";
	}
	
	@RequestMapping(value = "/nuovoAutore", method = RequestMethod.GET)
	public String formAutore (Model model) {
		model.addAttribute("autore", new Autore());
		return "nuovoAutore.html";
	}
	
	@RequestMapping(value = "/nuovoAutore", method = RequestMethod.POST)
	public String addAutore (@ModelAttribute("autore") Autore a, Model model) {
		this.as.salva(a);
		model.addAttribute("autori", this.as.listaAutori());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/{id}/editAutore", method = RequestMethod.GET)
	public String editAutore (@PathVariable("id") Long id, Model model) {
		model.addAttribute("autoreNuovo", new Autore());
		model.addAttribute("autore", this.as.cercaId(id));
		return "editAutore.html";
	}
	
	@RequestMapping(value = "/autori/{id}/editAutore", method = RequestMethod.POST)
	public String editAutoreConfirm (@PathVariable("id") Long id, @ModelAttribute("autoreNuovo") Autore a, @ModelAttribute("autore") Autore aut, Model model) {
		if (a.getNome() != null)
			aut.setNome(a.getNome());
		if (a.getCognome() != null)
			aut.setCognome(a.getCognome());
		if (a.getDataNascita() != null)
			aut.setDataNascita(a.getDataNascita());
		if (a.getLuogoNascita() != null)
			aut.setLuogoNascita(a.getLuogoNascita());
		if (a.getNazionalita() != null)
			aut.setNazionalita(a.getNazionalita());
		this.as.salva(aut);
		model.addAttribute("autori", this.as.listaAutori());
		return "autori.html";
	}
	
	@RequestMapping(value = "/autori/{id}/deleteAutore", method = RequestMethod.GET)
	public String deleteAutoreForm (@PathVariable("id") Long id, Model model) {
		this.as.cancella(this.as.cercaId(id));
		model.addAttribute("autori", this.as.listaAutori());
		return "autori.html";
	}
	
}
