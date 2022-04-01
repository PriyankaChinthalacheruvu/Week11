package com.greatlearning.week9.pojo;

import io.micrometer.core.lang.Nullable;

import java.io.PrintWriter;

public class Criteria {

    @Nullable
    private int price;

    private String date ;

    public Criteria(int price, String date) {
        this.price = price;
        this.date = date;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
