package com.greatlearning.week9.pojo;

public class AdminReport {
    private int orderID;
    private String user;
    private float amount;
    private String orderDate;
    private String orderCity;
    private String month;
    private String year;

    public AdminReport(int orderID, String user, float amount, String orderDate, String orderCity, String month, String year) {
        this.orderID = orderID;
        this.user = user;
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderCity = orderCity;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "AdminReport{" +
                "orderID=" + orderID +
                ", user='" + user + '\'' +
                ", amount=" + amount +
                ", orderDate='" + orderDate + '\'' +
                ", orderCity='" + orderCity + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public AdminReport() {
    }

}
