package br.com.paulo.forumAlura.service.dto;

public class TokenDto {

	private String token;
	private String string;

	public TokenDto(String token, String string) {
		this.token = token;
		this.string = string;
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
}
