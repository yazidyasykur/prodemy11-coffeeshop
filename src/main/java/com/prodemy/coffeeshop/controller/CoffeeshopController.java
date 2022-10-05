package com.prodemy.coffeeshop.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodemy.coffeeshop.model.Menu;
import com.prodemy.coffeeshop.model.Order;
import com.prodemy.coffeeshop.model.WaitList;
import com.prodemy.coffeeshop.service.MenuService;
import com.prodemy.coffeeshop.service.OrderService;
import com.prodemy.coffeeshop.service.WaitListService;

@Controller
public class CoffeeshopController {
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private WaitListService waitService;

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
	    WaitList wait = new WaitList();
	    
	    order.setOrderId(req.getParameter("orderId"));
	    order.setOrderDate(req.getParameter("dateTime"));
	    order.setCustomerName(req.getParameter("nama"));
	    order.setOrderList(req.getParameter("orders"));
	    order.setTotalAmount(req.getParameter("totalAmount"));
	    
	    wait.setOrderId(req.getParameter("orderId"));
	    wait.setOrderDate(req.getParameter("dateTime"));
	    wait.setCustomerName(req.getParameter("nama"));
	    wait.setOrderList(req.getParameter("orders"));
	    
	    orderService.saveOrder(order);
	    waitService.addOrder(wait);
	 
	    return "/customer";
	}
	
	@RequestMapping("/waitinglist")
    public ModelAndView waitingList(ModelAndView model, HttpServletRequest req) {
        List<WaitList> waitlist = waitService.listAll();
        model.addObject("allList", waitlist);
        model.setViewName("waiting-list");
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
	
	

}


