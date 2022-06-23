package br.com.calixto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class FooBarController {

	@GetMapping("/foo-bar")
	public String foobar() {
		return "Foo-Bar!!!";
	}
}
