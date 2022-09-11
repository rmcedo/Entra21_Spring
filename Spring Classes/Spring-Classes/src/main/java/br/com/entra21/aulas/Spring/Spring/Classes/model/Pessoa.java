package br.com.entra21.aulas.Spring.Spring.Classes.model;

public class Pessoa extends MaturidadeNivel3Richardson{

	private String nome;
	private int idade;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	
	
}
