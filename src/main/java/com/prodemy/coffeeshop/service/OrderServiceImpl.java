package com.prodemy.coffeeshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodemy.coffeeshop.dao.OrderDao;
import com.prodemy.coffeeshop.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderdao;
    
    @Override
    @Transactional
    public List<Order> listOrder() {
        return orderdao.getAll();
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderdao.insert(order);
    }

	@Override
	@Transactional
	public List<Order> listOrderSorted() {
		return orderdao.getAllSorted();
	}

}
