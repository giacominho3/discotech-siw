package it.uniroma3.siw.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name= "credenziali", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Credenziali {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "credenziali_ruolo",
			joinColumns = @JoinColumn(
		            name = "credenziali_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "ruolo_id", referencedColumnName = "id"))
	private Collection<Ruolo> ruolo;
	
	public Credenziali(String firstName, String lastName, String email, String password, Collection<Ruolo> ruolo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	public Credenziali() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<Ruolo> getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(Collection<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}
}