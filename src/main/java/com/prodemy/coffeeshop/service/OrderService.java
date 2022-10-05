package com.prodemy.coffeeshop.service;

import java.util.List;

import com.prodemy.coffeeshop.model.Order;

public interface OrderService {
    
    public List<Order> listOrder();
    public void saveOrder(Order order);
    
}
