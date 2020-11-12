package br.com.paulo.forumAlura.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paulo.forumAlura.model.Usuario;
import br.com.paulo.forumAlura.repository.UsuarioRepository;
import br.com.paulo.forumAlura.service.dto.UsuarioDto;
import br.com.paulo.forumAlura.service.form.UsuarioForm;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrarusuario(@RequestBody @Valid UsuarioForm UsuarioForm,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = UsuarioForm.converter(usuariorepository);
		usuariorepository.save(usuario);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));

	}
}
