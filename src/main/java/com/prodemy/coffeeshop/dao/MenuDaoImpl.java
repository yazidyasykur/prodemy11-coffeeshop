package com.prodemy.coffeeshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodemy.coffeeshop.model.Menu;

@Repository
public class MenuDaoImpl implements MenuDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Menu> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Menu> list = session.createQuery("from Menu").list();
        return list;
    }

    @Override
    public Menu findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Menu m = session.load(Menu.class, id);
        session.delete(m);
    }

    @Override
    public void insert(Menu menu) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(menu);
    }

    @Override
    public void update(Menu menu) {
        Session session = sessionFactory.getCurrentSession();
        session.update(menu);
    }

}
