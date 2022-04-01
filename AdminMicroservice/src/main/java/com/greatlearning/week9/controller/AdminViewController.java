package com.greatlearning.week9.controller;


import com.greatlearning.week9.pojo.AdminMaxMonthReport;
import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.AdminReport;
import com.greatlearning.week9.service.AdminViewService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AdminViewController {
    @Autowired
    private AdminViewService service;

    @GetMapping("/viewAllSales")
    public List<AdminReport> getAllSales(String city) {
        log.info("GET All Sales vs CITY");
        List<AdminReport> adminReportList = service.getAll(city);
        return adminReportList;
    }

    @GetMapping("/viewMaxSales")
    public List<AdminMaxMonthReport> getMonthlyMaxSales(@RequestParam(required = true) String month) {
        log.info("Inside get order by Criteria");
        List<AdminMaxMonthReport> adminReportList = service.getByMaxMonth(month);
        return adminReportList;
    }

    @GetMapping("/viewYearlySales")
    public List<AdminMaxMonthReport> getYearlySales(@RequestParam(required = true) String year) {
        log.info("Inside get order by Criteria");
        List<AdminMaxMonthReport> adminReportList = service.getGroupByYear(year);
        return adminReportList;
    }

}
