package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Raccolta {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private String visibilità;
	
	//serve data creazione qui
	
	@ManyToOne
	private Utente possessore;
	
	@OneToMany
	@JoinColumn(name = "brani_id")
	private List<Brano> brani;
	
	public Raccolta() {
		this.brani = new ArrayList<>();
	}
	
	public Raccolta(Utente p, String t, String v) {
		this();
		this.possessore = p;
		this.titolo = t;
		this.visibilità = v;
	}

	public Utente getPossessore() {
		return possessore;
	}

	public void setPossessore(Utente possessore) {
		this.possessore = possessore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String nome) {
		this.titolo = nome;
	}

	public String getVisibilità() {
		return visibilità;
	}

	public void setVisibilità(String visibilità) {
		this.visibilità = visibilità;
	}

	public List<Brano> getBrani() {
		return brani;
	}
	
	public void addBrano(Brano brano) {
		this.brani.add(brano);
	}
	
	public void removeBrano(Brano brano) {
		this.brani.remove(brano);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Raccolta other = (Raccolta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
