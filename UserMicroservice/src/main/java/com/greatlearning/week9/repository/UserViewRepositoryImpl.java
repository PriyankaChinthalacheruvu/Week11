package com.greatlearning.week9.repository;

import com.greatlearning.week9.constants.SQLConstants;
import com.greatlearning.week9.pojo.Criteria;
import com.greatlearning.week9.pojo.UserOrder;
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
public class UserViewRepositoryImpl implements UserViewRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    @Override
    public List<UserOrder> getAll(String currentUserName) {

        String query = SQLConstants.SELECT_ALL_ORDEREDITEMS;
        Map<String,String> namedArg = new HashMap<>();
        namedArg.put("user",currentUserName);
        List<UserOrder> orders = jdbcTemplate.query(query,namedArg,new OrderMapper());
        return orders;
    }

    @Override
    public List<UserOrder> getAllBy(Criteria criteria, String currentUserName) {

        String query = SQLConstants.SELECT_ALL_ORDEREDITEMS;
        if(criteria.getDate()!=null){
            query+=" AND orderDate='"+criteria.getDate()+"'";
        }
        if(String.valueOf(criteria.getPrice())==null){
            query+=" AND itemPrice="+criteria.getPrice();

        }
        Map<String,String> namedArg = new HashMap<>();
        namedArg.put("user",currentUserName);
        List<UserOrder> orders = jdbcTemplate.query(query,namedArg,new OrderMapper());
        return orders;
    }

    @Override
    public void save(String username, String date, String city, int price) {
        String query = SQLConstants.UPDATE_ORDEREDITEMS;
        Map<String,Object> namedArg = new HashMap<>();
        namedArg.put("user",username);
        namedArg.put("orderDate",date);
        namedArg.put("orderCity",city);
        namedArg.put("itemPrice",new Integer(price));

        namedArg.put("month",date.substring(3,5));
        namedArg.put("year",date.substring(6));
        jdbcTemplate.update(query,namedArg);
    }


    public static final class OrderMapper implements RowMapper<UserOrder>{


        @Override
        public UserOrder mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            UserOrder userOrder=new UserOrder();
            userOrder.setFood_id(resultSet.getInt("food_id"));
            userOrder.setName(resultSet.getString("name"));
            userOrder.setPrice(resultSet.getInt("price"));
            userOrder.setOrderDate(resultSet.getString("orderDate"));
            userOrder.setOrderCity(resultSet.getString("orderCity"));
            return userOrder;
        }
    }

}

