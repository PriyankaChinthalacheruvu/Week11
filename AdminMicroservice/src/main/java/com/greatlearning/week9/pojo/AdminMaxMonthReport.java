package com.greatlearning.week9.pojo;

public class AdminMaxMonthReport {


    private String year;
    private String month;
    private String orderCity;
    private float amount;

    public AdminMaxMonthReport(String year, String month, String orderCity, float amount) {
        this.year = year;
        this.month = month;
        this.orderCity = orderCity;
        this.amount = amount;
    }

    public AdminMaxMonthReport() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AdminMaxMonthReport{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", orderCity='" + orderCity + '\'' +
                ", amount=" + amount +
                '}';
    }
}
