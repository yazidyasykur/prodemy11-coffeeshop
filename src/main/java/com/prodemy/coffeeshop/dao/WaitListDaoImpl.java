package com.prodemy.coffeeshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodemy.coffeeshop.model.WaitList;

@Repository
public class WaitListDaoImpl implements WaitListDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<WaitList> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<WaitList> waitList = session.createQuery("from WaitList").list();
        return waitList;
    }

    @Override
    public void deleteById(String id) {
        Session session = sessionFactory.getCurrentSession();
        WaitList waitlist = session.load(WaitList.class, id);
        session.delete(waitlist);
    }

    @Override
    public void insert(WaitList waitlist) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(waitlist);
    }

}
