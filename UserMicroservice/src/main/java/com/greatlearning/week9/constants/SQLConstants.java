package com.greatlearning.week9.constants;

public class SQLConstants {

    public static final String SELECT_ALL_ORDEREDITEMS = "SELECT orderID as food_id, user as name, itemPrice as price , orderDate, orderCIty \n" +
            "from restaurant_db.orderhistory\n" +
            "where user= :user";

    public static final String UPDATE_ORDEREDITEMS = "INSERT INTO `restaurant_db`.`orderhistory`\n" +
            "(`user`,\n" +
            "`itemPrice`,\n" +
            "`orderDate`,`orderCity`,\n" +
            "`month`,\n" +
            "`year`)\n" +
            "VALUES\n" +
            "(:user,:itemPrice,:orderDate,:orderCity,:month,:year)";
}
