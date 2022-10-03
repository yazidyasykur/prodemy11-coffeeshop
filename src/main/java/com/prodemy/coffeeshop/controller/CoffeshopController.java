package com.prodemy.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;


@Controller
public class CoffeshopController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/customer")
	public String orderCoffee() {
		return "customer";
	}
	
	@RequestMapping("/login")
    public String login() {
        return "login";
    }
	
	@RequestMapping("/register")
    public String register() {
        return "regist-form";
    }
	
	@RequestMapping("/owner")
    public String owner() {
        return "owner";
    }
	

}


