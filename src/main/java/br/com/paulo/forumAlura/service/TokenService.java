package br.com.paulo.forumAlura.service;

import org.springframework.security.core.Authentication;


public interface TokenService {

	String gerarToken(Authentication authenticate);

	boolean isTokenValido(String token);

	void autenticarCliente(String token);


	
	
}
