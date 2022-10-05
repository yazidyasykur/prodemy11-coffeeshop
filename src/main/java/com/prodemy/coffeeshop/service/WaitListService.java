package com.prodemy.coffeeshop.service;

import java.util.List;

import com.prodemy.coffeeshop.model.WaitList;

public interface WaitListService {

    public List<WaitList> listAll();
    public void deleteOrder(String id);
    public void addOrder(WaitList waitlist);
}
