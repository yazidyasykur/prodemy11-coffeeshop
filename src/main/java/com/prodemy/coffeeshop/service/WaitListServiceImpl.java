package com.prodemy.coffeeshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodemy.coffeeshop.dao.WaitListDao;
import com.prodemy.coffeeshop.model.WaitList;

@Service
public class WaitListServiceImpl implements WaitListService {

    @Autowired
    WaitListDao waitdao;
    
    @Override
    @Transactional
    public List<WaitList> listAll() {
        return waitdao.getAll();
    }

    @Override
    public void deleteOrder(String id) {
        waitdao.deleteById(id);
    }

    @Override
    @Transactional
    public void addOrder(WaitList waitlist) {
        waitdao.insert(waitlist);
    }

}
