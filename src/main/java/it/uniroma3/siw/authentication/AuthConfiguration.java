package it.uniroma3.siw.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import it.uniroma3.siw.service.CredenzialiService;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CredenzialiService credenzialiService;
	
	//Definisce come criptare la password nel DB
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Recupera i dettagli dell'utente dal file UserDetailsService
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(credenzialiService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	//Specifica come il sistema deve recuperare username, password e ruoli nel DB
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	/*
	 * Definisce le policies di autenticazione e autorizzazione attraverso una serie di invocazioni concatenante
	 * all'ogetto http: i metodi restituiscono lo stesso oggetto http
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers(
				"/**",
				"/index**",						// Chiunque autenticato o no può accedere 
				"/login**",						// alle pagine index, login, registrazione,
				"/registrazione**",				// ai js, css e alle immagini
				"/js/**",						
				"/css/**",						
				"/img/**").permitAll()
		.antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority()	//solo gli utenti con ruolo di admin possono accedere alle risorse con path /admin/**
		.anyRequest().authenticated()			// Tutti gli utenti autenticati possono accedere alle pagine rimanenti
		.and()
		.formLogin()
		.loginPage("/login")					// La pagina di login si trova a /login
		.permitAll()
		.defaultSuccessUrl("/home")				// Se il login ha successo, si viene rediretti alla home
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")		// In caso di successo, si viene reidiretti 
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("logout"))
		.clearAuthentication(true).permitAll();
		
		
	}
	
}