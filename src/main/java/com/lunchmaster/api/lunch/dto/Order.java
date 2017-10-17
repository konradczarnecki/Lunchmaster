package com.lunchmaster.api.lunch.dto;

import com.lunchmaster.api.restaurant.dto.Dish;
import com.lunchmaster.api.user.dto.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.slefarski on 2017-10-13.
 */

@Entity
@Table(name= "lunchorder")
public class Order {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="note")
    private String note;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "user_id")
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(
            name="lunchorder_dish",
            joinColumns=@JoinColumn(name="lunchorder_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="dish_id", referencedColumnName="id"))

    private List<Dish> dishes;

    public Order(){
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

    public void setUser(User user) {
        this.user = user;

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
