package com.prodemy.coffeeshop.dao;

import java.util.List;

import com.prodemy.coffeeshop.model.Order;

public interface OrderDao {
    
    public List<Order> getAll();
    public void insert(Order order);
}
