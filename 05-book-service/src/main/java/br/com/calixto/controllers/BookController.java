package br.com.calixto.controllers;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calixto.model.Book;

@RestController
@RequestMapping("book-service") 
public class BookController {

	@Autowired 
	 private Environment environment;
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(
			@PathVariable("id") final Long id,
			@PathVariable("currency") final String currency) {
		
		final var port = environment.getProperty("local.server.port");
		
		return new Book(1L, "Nigel Poulton", "Docker Deep Dive", new Date(), Double.valueOf(22.7), currency, port);
	}
}
