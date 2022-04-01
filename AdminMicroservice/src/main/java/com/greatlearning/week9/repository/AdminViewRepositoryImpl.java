package com.greatlearning.week9.repository;

import com.greatlearning.week9.constants.SQLConstants;
import com.greatlearning.week9.pojo.AdminMaxMonthReport;
import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.AdminReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminViewRepositoryImpl implements AdminViewRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    @Override
    public List<AdminReport> getAll(String city) {

        String query = SQLConstants.SELECT_SALES;
        if(city!=null){
            query = SQLConstants.SLECT_SALES_BY_CITY;
            Map<String,String> namedArg = new HashMap<>();
            namedArg.put("orderCity",city);
            List<AdminReport> orders = jdbcTemplate.query(query,namedArg,new CityMapper());
            return orders;
        }
        else {
            List<AdminReport> orders = jdbcTemplate.query(query, new CityMapper());
            return orders;
        }
    }

    @Override
    public List<AdminMaxMonthReport> getByMaxMonth(String month) {

        String query = SQLConstants.SELECT_MAX_MONTH;

        Map<String,String> namedArg = new HashMap<>();
        namedArg.put("month",month);
        List<AdminMaxMonthReport> orders = jdbcTemplate.query(query,namedArg,new MaxMonthMapper());
        return orders;
    }

    @Override
    public List<AdminMaxMonthReport> getGroupByYear(String year) {
        String query = SQLConstants.SELECT_GROUP_BY_MONTH_YEAR;
        Map<String,Object> namedArg = new HashMap<>();
        namedArg.put("year",year);
        List<AdminMaxMonthReport> orders = jdbcTemplate.query(query,namedArg,new MaxMonthMapper());
        return orders;
    }


    public static final class CityMapper implements RowMapper<AdminReport>{


        @Override
        public AdminReport mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            AdminReport adminReport =new AdminReport();
            adminReport.setOrderID(resultSet.getInt("orderID"));
            adminReport.setUser(resultSet.getString("user"));
            adminReport.setAmount(resultSet.getInt("itemPrice"));
            adminReport.setOrderDate(resultSet.getString("orderDate"));
            adminReport.setOrderCity(resultSet.getString("orderCity"));
            adminReport.setMonth(resultSet.getString("month"));
            adminReport.setYear(resultSet.getString("year"));
            return adminReport;
        }
    }

    public static final class MaxMonthMapper implements RowMapper<AdminMaxMonthReport>{


        @Override
        public AdminMaxMonthReport mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            AdminMaxMonthReport adminReport =new AdminMaxMonthReport();
            adminReport.setAmount(resultSet.getInt("itemPrice"));
            adminReport.setOrderCity(resultSet.getString("orderCity"));
            adminReport.setMonth(resultSet.getString("month"));
            adminReport.setYear(resultSet.getString("year"));
            return adminReport;
        }
    }

}

