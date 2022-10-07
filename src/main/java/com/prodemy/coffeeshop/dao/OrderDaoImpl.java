package com.prodemy.coffeeshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodemy.coffeeshop.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("from Order").list();
        return orderList;
    }

    @Override
    public void insert(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

	@Override
	public List<Order> getAllSorted() {
		Session session = sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("from Order order by order_date desc").list();
        return orderList;
	}

}
