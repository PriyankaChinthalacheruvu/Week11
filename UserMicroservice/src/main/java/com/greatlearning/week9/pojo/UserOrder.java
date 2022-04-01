package com.greatlearning.week9.pojo;

public class UserOrder {
    private int food_id;
    private String name;
    private float price;
    private String orderDate;
    private String orderCity;

    public UserOrder(int food_id, String name, String madein, float price, String orderDate, String orderCity) {
        this.food_id = food_id;
        this.name = name;

        this.price = price;
        this.orderDate = orderDate;
        this.orderCity = orderCity;
    }

    public UserOrder() {
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "food_id=" + food_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderDate='" + orderDate + '\'' +
                ", orderCity='" + orderCity + '\'' +
                '}';
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
}
