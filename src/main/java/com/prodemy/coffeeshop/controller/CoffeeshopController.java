package com.prodemy.coffeeshop.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodemy.coffeeshop.model.Menu;
import com.prodemy.coffeeshop.model.Order;
import com.prodemy.coffeeshop.service.MenuService;
import com.prodemy.coffeeshop.service.OrderService;

@Controller
public class CoffeeshopController {
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private OrderService orderService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/customer")
	public ModelAndView orderCoffee(ModelAndView model) {
	    List<Menu> menulist = menuService.listMenu();
	    model.addObject("allMenu", menulist);
		model.setViewName("customer");
		model.addObject("orderId", UUID.randomUUID().toString());
		return model;
	}
	
	
	@PostMapping("/saveorder")
	public String viewWaitingList(Model model, HttpServletRequest req) {
	    Order order = new Order();
	    
	    order.setOrderId(req.getParameter("orderId"));
	    order.setOrderDate(req.getParameter("dateTime"));
	    order.setCustomerName(req.getParameter("nama"));
	    order.setOrderList(req.getParameter("orders"));
	    order.setTotalAmount(req.getParameter("totalAmount"));
	    
	    orderService.saveOrder(order);
	 
	    return "/customer";
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


