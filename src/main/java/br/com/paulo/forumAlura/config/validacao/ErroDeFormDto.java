package br.com.paulo.forumAlura.config.validacao;

public class ErroDeFormDto {

	private String campo;
	private String mensagemErro;

	public ErroDeFormDto(String campo, String mensagemErro) {
	
		this.campo = campo;
		this.mensagemErro = mensagemErro;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}


}
