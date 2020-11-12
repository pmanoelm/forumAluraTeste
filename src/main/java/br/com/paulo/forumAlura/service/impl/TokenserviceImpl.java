package br.com.paulo.forumAlura.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.paulo.forumAlura.model.Usuario;
import br.com.paulo.forumAlura.repository.UsuarioRepository;
import br.com.paulo.forumAlura.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenserviceImpl implements TokenService {
	@Value("${forumAlura.jwt.expiration}")
	private String expiration;
	@Value("${forumAlura.jwt.secret}")
	private String secretKey;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public String gerarToken(Authentication authenticate) {
		Usuario logado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setIssuer("API do Forum Alura")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiration)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}

	@Override
	public boolean isTokenValido(String token) {

		try {
			Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void autenticarCliente(String token) {

		Claims claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
		long idUsuario = Long.parseLong(claims.getSubject());
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null,
				usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

}
