package com.lunchmaster.api.lunch.dto;

import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.restaurant.dto.Dish;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.slefarski on 2017-10-13.
 */

@Entity
@Table(name = "lunchorder")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "lunch_id")
    private int lunchId;

    @Column(name = "note")
    private String note;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(
            name = "lunchorder_dish",
            joinColumns = @JoinColumn(name = "lunchorder_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private List<Dish> dishes;

    public Order() {
        this.dishes = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "order:\n" +
                "{\n" +
                "id: " + this.id + "\n" +
                "lunchId: " + this.lunchId + "\n" +
                "note: " + this.note + "\n" +
                "....\n" +
                "}";
    }

}
