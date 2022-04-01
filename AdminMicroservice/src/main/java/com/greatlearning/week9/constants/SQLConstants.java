package com.greatlearning.week9.constants;

public class SQLConstants {

    public static final String SELECT_SALES = "SELECT orderID, user, orderDate, orderCity, month, year, itemPrice \n" +
            "FROM restaurant_db.orderhistory \n" +
            "ORDER BY orderCity asc";

    public static final String SLECT_SALES_BY_CITY = "SELECT orderID, user, orderDate, orderCity, month, year, itemPrice \n" +
            "FROM restaurant_db.orderhistory\n" +
            "WHERE orderCity= :orderCity\n" +
            "ORDER BY orderCity asc";

    public static final String SELECT_MAX_MONTH ="SELECT orderCity,year,month,MAX(itemPrice) as itemPrice\n" +
            "FROM(\n" +
            "SELECT  orderCity,\n" +
            "year, \n" +
            "month,\n" +
            "orderDate,\n" +
            "SUM(itemPrice)\n" +
            "as itemPrice\n" +
            "FROM restaurant_db.orderhistory  \n" +
            "WHERE month =:month\n" +
            "GROUP BY orderDate,ordercity,month,year\n" +
            ") a GROUP BY month,year,orderCity";

    public static final String SELECT_GROUP_BY_MONTH_YEAR = "SELECT  orderCity,\n" +
            "year, \n" +
            "month,\n" +
            "SUM(itemPrice)\n" +
            "as itemPrice\n" +
            "FROM restaurant_db.orderhistory \n" +
            "WHERE year=:year \n" +
            "GROUP BY ordercity,month,year\n" +
            "ORDER BY orderCity asc, year desc, month asc;";
}
