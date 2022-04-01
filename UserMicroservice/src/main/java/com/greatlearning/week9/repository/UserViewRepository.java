package com.greatlearning.week9.repository;

import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.UserOrder;

import java.util.List;

public interface UserViewRepository {

    List<UserOrder> getAll(String currentUserName);

    List<UserOrder> getAllBy(Criteria criteria, String currentUserName);


    void save(String username, String date, String city, int price);
}
