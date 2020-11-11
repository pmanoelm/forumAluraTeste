package br.com.paulo.forumAlura.service.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.paulo.forumAlura.model.Topico;
import br.com.paulo.forumAlura.repository.TopicoRepository;

public class AtualizcaoTopicoForm {
	@Length(min = 5)
	@NotEmpty
	@NotBlank
	private String titulo;
	@NotBlank
	@NotEmpty
	@Length(min = 15)
	private String mensagem;


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

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;
	}

}
