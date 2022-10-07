package com.prodemy.coffeeshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodemy.coffeeshop.dao.MenuDao;
import com.prodemy.coffeeshop.model.Menu;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menudao;
    
    @Override
    @Transactional
    public List<Menu> listMenu() {
        return menudao.getAll();
    }

    @Override
    @Transactional
    public void hapusMenu(String id) {
        menudao.deleteById(id);
    }

    @Override
    @Transactional
    public void tambahMenu(Menu menu) {
       menudao.insert(menu);      
    }


    @Override
    @Transactional
    public void editMenu(Menu menu) {
       menudao.update(menu);
    }

	@Override
	@Transactional
	public Menu findById(String id) {
		return menudao.findById(id);
	}

	@Override
	@Transactional
	public int hitungJumlahMenu() {
		return menudao.countMenu();
	}

}
