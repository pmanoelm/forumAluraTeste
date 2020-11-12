package br.com.paulo.forumAlura.service.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.paulo.forumAlura.model.Usuario;
import br.com.paulo.forumAlura.repository.UsuarioRepository;

public class UsuarioForm {
	private Long id;
	private String nome;
	@NotBlank
	@NotEmpty
	@Length(min = 5)
	private String email;
	@NotBlank
	@NotEmpty
	@Length(min = 3)
	private String senha;
	
	
		
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public Usuario converter(UsuarioRepository usuariorepository) {
				
		Optional<Usuario> usuario= usuariorepository.findByEmail(email);
		return new Usuario(this.nome,email,new BCryptPasswordEncoder().encode("senha")) ;
	}
	
	
}
