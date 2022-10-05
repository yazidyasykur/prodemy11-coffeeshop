package com.prodemy.coffeeshop.dao;

import java.util.List;

import com.prodemy.coffeeshop.model.WaitList;

public interface WaitListDao {
    
    public List<WaitList> getAll();
    public void insert(WaitList waitlist);
    public void deleteById(String id);
    
}
