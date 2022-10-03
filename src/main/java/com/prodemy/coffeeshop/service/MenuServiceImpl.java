package com.prodemy.coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prodemy.coffeeshop.dao.MenuDao;
import com.prodemy.coffeeshop.model.Menu;

public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menudao;
    
    @Override
    public List<Menu> listMenu() {
        return menudao.getAll();
    }

    @Override
    public void hapusMenu(String id) {
        menudao.deleteById(id);
    }

    @Override
    public void tambahMenu(Menu menu) {
        menudao.insert(menu);      
    }

    @Override
    public void editMenu(Menu menu) {
        menudao.update(menu);
    }

}
