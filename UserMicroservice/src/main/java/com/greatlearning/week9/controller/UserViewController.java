package com.greatlearning.week9.controller;

import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.pojo.UserOrder;
import com.greatlearning.week9.service.ProductService;
import com.greatlearning.week9.service.UserViewService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class UserViewController {
    @Autowired
    private UserViewService service;

    @GetMapping("/viewOrder")
    public List<UserOrder> getOrder() {
        String currentUserName ="";
        log.info("GET All Orders by user");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //to get logged in user Information
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        List<UserOrder> listProducts = service.getAll(currentUserName);
        return listProducts;
    }

    @GetMapping("/viewOrder/byCriteria")
    public List<UserOrder> getOrderbyCriteria( Criteria criteria) {
        log.info("Inside get order by Criteria");
        String currentUserName ="";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        List<UserOrder> product = service.getOrderBy(criteria,currentUserName);
        return product;
    }

}
