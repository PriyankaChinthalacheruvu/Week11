package com.greatlearning.week9.repository;

import com.greatlearning.week9.pojo.AdminMaxMonthReport;
import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.AdminReport;

import java.util.List;

public interface AdminViewRepository {

    List<AdminReport> getAll(String city);

    List<AdminMaxMonthReport> getByMaxMonth(String month);


    List<AdminMaxMonthReport> getGroupByYear(String year);
}
