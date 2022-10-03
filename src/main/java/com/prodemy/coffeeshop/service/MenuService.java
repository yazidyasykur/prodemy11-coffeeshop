package com.prodemy.coffeeshop.service;

import java.util.List;

import com.prodemy.coffeeshop.model.Menu;

public interface MenuService {

    public List<Menu> listMenu();
    public void hapusMenu(String id);
    public void tambahMenu(Menu menu);
    public void editMenu(Menu menu);
    
}
