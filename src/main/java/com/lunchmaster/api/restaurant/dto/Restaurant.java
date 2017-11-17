package com.lunchmaster.api.restaurant.dto;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.slefarski on 2017-09-26.
 */

@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="link")
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "avg_delivery_time")
    private int avgDeliveryTime;

    @Column(name = "logo")
    private String logo;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Dish> dishes;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvgDeliveryTime() {
        return avgDeliveryTime;
    }

    public void setAvgDeliveryTime(int avgDeliveryTime) {
        this.avgDeliveryTime = avgDeliveryTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Restaurant(){
        this.dishes=new ArrayList<Dish>();
    }

}
