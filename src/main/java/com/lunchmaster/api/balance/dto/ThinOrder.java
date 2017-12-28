package com.lunchmaster.api.balance.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by m.slefarski on 2017-12-28.
 */
public class ThinOrder {

    private int id;

    private int userId;

    private String userFirstName;

    private String userLastName;

    private int lunchId;

    @JsonIgnore
    private boolean isSettled;

    private Date date;

    private String restaurantName;

    private List<ThinDish> dishes;

    public ThinOrder(){
        this.isSettled=false;
        this.dishes=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled(boolean settled) {
        isSettled = settled;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<ThinDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<ThinDish> dishes) {
        this.dishes = dishes;
    }

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
