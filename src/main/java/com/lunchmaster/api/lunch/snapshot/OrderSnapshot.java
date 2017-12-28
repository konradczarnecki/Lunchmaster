package com.lunchmaster.api.lunch.snapshot;

import com.lunchmaster.api.restaurant.dto.Dish;

import java.util.List;

public class OrderSnapshot {

    private int id;
    private String note;
    private UserSnapshot user;
    private List<Dish> dishes;

    public OrderSnapshot() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserSnapshot getUser() {
        return user;
    }

    public void setUser(UserSnapshot user) {
        this.user = user;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "OrderSnapshot{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", dishes=" + dishes +
                '}';
    }
}
