package com.prodemy.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;


@Controller
public class CoffeshopController {

	@RequestMapping("/")
	public String listMahasiswa() {
		return "index";
	}

}


