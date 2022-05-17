package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Credenziali {
	
	public static final String DEFAULT_ROLE = "DEFAULT";
	
	public static final String ADMIN_ROLE = "ADMIN";
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (unique = true, nullable = false, length = 100)
	private String username;
	@Column (nullable = false, length = 100)
	private String password;
	@Column (nullable = false, length = 10)
	private String ruolo;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Utente utente;
	
	public Credenziali () {
		this.utente = new Utente();
	}
	
	public Credenziali (String u) {
		this();
		this.username = u;
	}
	
	public Utente getUser() {
		return utente;
	}


	public void setUser(Utente u) {
		this.utente = u;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
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
		Credenziali other = (Credenziali) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
