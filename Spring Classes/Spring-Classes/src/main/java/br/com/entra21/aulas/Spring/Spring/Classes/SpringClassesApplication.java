package br.com.entra21.aulas.Spring.Spring.Classes;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.entra21.aulas.Spring.Spring.Classes.model.Pessoa;
import br.com.entra21.aulas.Spring.Spring.Classes.model.Usuario;

@SpringBootApplication
public class SpringClassesApplication implements CommandLineRunner {
	
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		SpringApplication.run(SpringClassesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		usuarios.add(new Usuario("rafael@email.com", "Senh@f0rte"));
		usuarios.add(new Usuario("admin@email.com", "admin"));
		pessoas.add(new Pessoa("Pessoa1", 33));
		pessoas.add(new Pessoa("Pessoa2", 35));
		pessoas.add(new Pessoa("Pessoa3", 31));
		pessoas.add(new Pessoa("Pessoa4", 20));
		pessoas.add(new Pessoa("Pessoa5", 28));
		
		
		
	}

}
