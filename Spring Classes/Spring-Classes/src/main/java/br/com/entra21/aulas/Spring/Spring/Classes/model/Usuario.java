package br.com.entra21.aulas.Spring.Spring.Classes.model;

public class Usuario extends MaturidadeNivel3Richardson{
	
	private String email;
	private String senha;
	
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public Usuario() {
		super();
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
	
	
	

}
