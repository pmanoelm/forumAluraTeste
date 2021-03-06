package br.com.paulo.forumAlura.service.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.paulo.forumAlura.model.Curso;
import br.com.paulo.forumAlura.model.Topico;
import br.com.paulo.forumAlura.repository.CursoRepository;

public class TopicoForm {

	@Length(min = 5)
	@NotEmpty
	@NotBlank
	private String titulo;
	@NotBlank
	@NotEmpty
	@Length(min = 5)
	private String mensagem;
	@NotBlank
	@NotEmpty
	@Length(min = 5)
	private String nomeCruso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCruso() {
		return nomeCruso;
	}

	public void setNomeCruso(String nomeCruso) {
		this.nomeCruso = nomeCruso;
	}

	public Topico converter(CursoRepository cursoRepository) {

		Curso curso = cursoRepository.findByNome(nomeCruso);
		return new Topico(titulo, mensagem, curso);
	}

}
