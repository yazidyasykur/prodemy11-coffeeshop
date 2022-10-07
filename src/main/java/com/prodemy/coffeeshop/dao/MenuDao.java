package com.prodemy.coffeeshop.dao;

import java.util.List;

import com.prodemy.coffeeshop.model.Menu;

public interface MenuDao {
    
    public List<Menu> getAll();
    public Menu findById(String id);
    public void deleteById(String id);
    public int countMenu();
    public void insert(Menu menu);
    public void update(Menu menu);
    
}
