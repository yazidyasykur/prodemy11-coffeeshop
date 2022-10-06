package com.prodemy.coffeeshop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prodemy.coffeeshop.model.Menu;
import com.prodemy.coffeeshop.model.Order;
import com.prodemy.coffeeshop.model.WaitList;
import com.prodemy.coffeeshop.service.MenuService;
import com.prodemy.coffeeshop.service.OrderService;
import com.prodemy.coffeeshop.service.WaitListService;
import com.prodemy.coffeeshop.util.IdUtility;


@Controller
public class CoffeeshopController {
    
    @Autowired(required = true)
    private MenuService menuService;
    
	@Qualifier(value = "menuService")
	public void setMenuService(MenuService mn) {
		this.menuService = mn;
	}
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private WaitListService waitService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value ="/customer", method = RequestMethod.GET)
	public ModelAndView orderCoffee(ModelAndView model) {
	    List<Menu> menulist = menuService.listMenu();
	    IdUtility util = new IdUtility();
	    
	    model.addObject("allMenu", menulist);
		model.setViewName("customer");
		model.addObject("orderId", util.letterFirstUUID());
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
	    
	    try {
            wait.setOrderList(URLEncoder.encode(req.getParameter("orders"),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	    
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
	
	@PostMapping("/deleteorder")
	public String deleteOrder(HttpServletRequest req) {
	    String id = req.getParameter("orderId");
	    waitService.deleteOrder(id);
	    return("redirect:/waitinglist");
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
	
	@RequestMapping("/remove/{menuId}")
	public String hapusMenu(@PathVariable("menuId") String menuId) {
		menuService.hapusMenu(menuId);
		return "redirect:/daftar-menu";
	}
	
	@RequestMapping(value = "/daftar-menu", method = RequestMethod.GET)
	public ModelAndView daftarMenu(ModelAndView model) {
	    List<Menu> menulist = menuService.listMenu();
	    model.addObject("allMenu", menulist);
		model.setViewName("daftar-menu");
		System.out.println(menulist);
		return model;
	}
	
	
	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest req) throws Exception {
		Menu mns = menuService.findById(req.getParameter("menuId"));
		model.addAttribute("mns", mns);
		List<Menu> list = menuService.listMenu();
		model.addAttribute("menulist", list);
		return "redirect:/daftar-menu";
	}
	
	@PostMapping("/mns")
	public String tambah(Model model, HttpServletRequest req) throws Exception {
		String mode = req.getParameter("mode");
		if ("tambah".equals(mode)) {
			Menu mns = new Menu();
			mns.setMenuId(req.getParameter("menuId"));
			mns.setMenuNama(req.getParameter("menuNama"));
			mns.setMenuTipe(req.getParameter("menuTipe"));
			mns.setMenuGambar(req.getParameter("menuGambar"));
			mns.setMenuDeskripsi(req.getParameter("menuDeskripsi"));
			mns.setMenuHarga(req.getParameter("menuHarga"));
			menuService.tambahMenu(mns);
		} else if ("hapus".equals(mode)) {
			menuService.hapusMenu(req.getParameter("menuId"));
		} else {
			Menu mns = menuService.findById(req.getParameter("menuId"));
			mns.setMenuNama(req.getParameter("menuNama"));
			mns.setMenuTipe(req.getParameter("menuTipe"));
			mns.setMenuDeskripsi(req.getParameter("menuDeskripsi"));
			menuService.editMenu(mns);			
		}
		return "redirect:/daftar-menu";
	}

	

	
}


