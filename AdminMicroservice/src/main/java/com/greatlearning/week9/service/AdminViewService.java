package com.greatlearning.week9.service;


import com.greatlearning.week9.pojo.AdminMaxMonthReport;
import com.greatlearning.week9.pojo.AdminReport;
import com.greatlearning.week9.repository.AdminViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminViewService {

    @Autowired
    private AdminViewRepository repo;

    public List<AdminReport> getAll(String city) {
        return repo.getAll(city);
    }


    public List<AdminMaxMonthReport> getByMaxMonth(String month) {
        return repo.getByMaxMonth(month);
    }

    public List<AdminMaxMonthReport> getGroupByYear(String year) {
       return repo.getGroupByYear( year);
    }

}