package br.com.entra21.aulas.Spring.Spring.Classes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.entra21.aulas.Spring.Spring.Classes.SpringClassesApplication;
import br.com.entra21.aulas.Spring.Spring.Classes.exceptions.DuplicateRequestException;
import br.com.entra21.aulas.Spring.Spring.Classes.model.ItemNivel3;
import br.com.entra21.aulas.Spring.Spring.Classes.model.Usuario;

@RestController

@CrossOrigin(origins = "*")

@RequestMapping("/sistema")

public class SistemaController {
	
	private final String PATH = "http://localhost:8080/sistema";
	
	@PostMapping("/register")

	@ResponseStatus(HttpStatus.CREATED)

	public @ResponseBody Usuario register(@RequestBody Usuario credenciais) {

	List<Usuario> busca = SpringClassesApplication.usuarios.stream()

	.filter(usuario -> usuario.getEmail().equals(credenciais.getEmail())).toList();



	if (!busca.isEmpty()) {

	throw new DuplicateRequestException();



	} else {

		SpringClassesApplication.usuarios.add(credenciais);

	}



	setMaturidadeNivel3(credenciais);



	return credenciais;

	}
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	
	public @ResponseBody List<Usuario> realizarLogin(@RequestBody Usuario credenciais) {

		List<Usuario> response = SpringClassesApplication.usuarios.stream()

				.filter(usuario -> usuario.getEmail().equals(credenciais.getEmail())

						&& usuario.getSenha().equals(credenciais.getSenha()))

				.toList();

		response.forEach(usuario -> {

		setMaturidadeNivel3(usuario);

		});

		return response;

	}

	private void setMaturidadeNivel3(Usuario usuario) {
		
		ArrayList<String>headers = new ArrayList<>(Arrays.asList(
				
					"Accept:application/json",
					"Content-Type:application/json"
				
				));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		usuario.setLinks(null);
		try {
			String json = mapper.writeValueAsString(usuario);
			usuario.setLinks(new ArrayList<>());
			usuario.getLinks().add(new ItemNivel3("POST", PATH+"/login", headers, json));
			usuario.getLinks().add(new ItemNivel3("POST", PATH+"/register", headers, json));
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
