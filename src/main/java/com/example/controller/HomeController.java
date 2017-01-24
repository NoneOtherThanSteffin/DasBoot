package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value  = "/home", , method = RequestMethod.GET)
	public String hello() {
		return "This is the first spring boot application";
	}
}
