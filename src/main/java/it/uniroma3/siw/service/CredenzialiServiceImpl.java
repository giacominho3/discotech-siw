package it.uniroma3.siw.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.dto.CredenzialiRegistrationDto;
import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Ruolo;
import it.uniroma3.siw.repository.CredenzialiRepository;

@Service
@Lazy
public class CredenzialiServiceImpl implements CredenzialiService{

	
	private CredenzialiRepository credenzialiRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public CredenzialiServiceImpl(CredenzialiRepository credenzialiRepository) {
		super();
		this.credenzialiRepository = credenzialiRepository;
	}

	@Override
	public Credenziali save(CredenzialiRegistrationDto registrationDto) {
		Credenziali credenziali = new Credenziali(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Ruolo("RUOLO_UTENTE")));
		
		return credenzialiRepository.save(credenziali);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Credenziali credenziali = credenzialiRepository.findByEmail(username);
		if(credenziali == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(credenziali.getEmail(),credenziali.getPassword(),mapRolesToAuthority(credenziali.getRuolo()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Ruolo> ruolo){
		
		return ruolo.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	
	}
}
