package br.com.entra21.aulas.Spring.Spring.Classes.exceptions;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseBody

@ResponseStatus(value = HttpStatus.CONFLICT,

		reason = "email already in use")

public class DuplicateRequestException extends RuntimeException {

}