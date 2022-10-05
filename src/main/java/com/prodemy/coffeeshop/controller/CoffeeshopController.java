package com.prodemy.coffeeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prodemy.coffeeshop.model.Menu;
import com.prodemy.coffeeshop.service.MenuService;

@Controller
public class CoffeeshopController {
    
    @Autowired
    private MenuService menuService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value ="/customer", method = RequestMethod.GET)
	public ModelAndView orderCoffee(ModelAndView model) {
	    List<Menu> menulist = menuService.listMenu();
	    model.addObject("allMenu", menulist);
		model.setViewName("customer");
		System.out.println(menulist);
		return model;
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
	@RequestMapping(value = "/daftar-menu", method = RequestMethod.GET)
	public ModelAndView daftarMenu(ModelAndView model) {
	    List<Menu> menulist = menuService.listMenu();
	    model.addObject("allMenu", menulist);
		model.setViewName("daftar-menu");
		System.out.println(menulist);
		return model;
	}
	@RequestMapping("/remove/{id}")
	public String removeMenu(@PathVariable("id") String id) {
		menuService.hapusMenu(id);
		return "redirect:/daftar-menu";
	}

	
	@RequestMapping(value = "/daftar-menu/add", method = RequestMethod.GET)
	public String tambahMenu(@ModelAttribute("menu") Menu m) {
		if (m.getMenuId() == "") {
			// new phone, add it
			menuService.tambahMenu(m);
		} else {
			// existing phone, call update
			menuService.editMenu(m);
		}
		return "redirect:/daftar-menu";
	}
	

}


