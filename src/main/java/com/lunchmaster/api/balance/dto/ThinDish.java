package com.lunchmaster.api.balance.dto;

/**
 * Created by m.slefarski on 2017-12-28.
 */
public class ThinDish {

    private int id;

    private String dishName;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
