package com.prodemy.coffeeshop.dao;

import java.util.List;

import com.prodemy.coffeeshop.model.Order;

public interface OrderDao {
    
    public List<Order> getAll();
    public List<Order> getAllSorted();
    public void insert(Order order);
}
