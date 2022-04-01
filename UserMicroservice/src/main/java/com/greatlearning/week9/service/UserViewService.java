package com.greatlearning.week9.service;


import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.pojo.UserOrder;
import com.greatlearning.week9.repository.UserViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserViewService {

    @Autowired
    private UserViewRepository repo;

    public List<UserOrder> getAll(String currentUserName) {
        return repo.getAll(currentUserName);
    }


    public List<UserOrder> getOrderBy(Criteria criteria, String currentUserName) {
        return repo.getAllBy(criteria,currentUserName);
    }

    public void saveOrderHistory(String username, String date, String city,int price) {
        repo.save(username,date,city,price);
    }

}