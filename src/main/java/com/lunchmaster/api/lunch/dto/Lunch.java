package com.lunchmaster.api.lunch.dto;


import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.login.dto.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.Date;


import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@Entity
@Table(name = "lunch")
public class Lunch implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="status")
    private String status;

    @Column(name="deadline")
    private Date deadline;

    @Column(name = "expected_delivery")
    private int expectedDelivery;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rst_id")
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lunchmaster_id")
    private User lunchMaster;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinColumn(name= "lunch_id")
    private List<Order> orders;

    public Lunch(){
        this.status=LunchStatus.OPEN.toString();
        this.orders = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getLunchMaster() {
        return lunchMaster;
    }

    public void setLunchMaster(User lunchMaster) {
        this.lunchMaster = lunchMaster;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(int expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        changeState(LunchStatus.valueOf(status));
    }


    /* Status checkers */


    public boolean isOpen(){
        return LunchStatus.valueOf(this.status).equals(LunchStatus.OPEN);
    }

    public boolean isClosed(){
        return LunchStatus.valueOf(this.status).equals(LunchStatus.CLOSED);
    }

    public boolean isOrdered(){
        return LunchStatus.valueOf(this.status).equals(LunchStatus.ORDERED);
    }

    public boolean isDelivered(){
        return LunchStatus.valueOf(this.status).equals(LunchStatus.DELIVERED);
    }

    public boolean isArchived(){
        return LunchStatus.valueOf(this.status).equals(LunchStatus.ARCHIVED);
    }


    /* State machine */
    public boolean changeState(LunchStatus ls){
        switch (LunchStatus.valueOf(this.status)){

            case OPEN:
                if(ls.equals(LunchStatus.CLOSED)){
                    this.status = ls.name();
                    return true;
                }

            case CLOSED:
                if(ls.equals(LunchStatus.ORDERED) || ls.equals(LunchStatus.CLOSED)){
                    this.status = ls.name();
                    return true;
                }

            case ORDERED:
                if(ls.equals(LunchStatus.DELIVERED)){
                    this.status=ls.name();
                    return true;
                }

            case DELIVERED:
                if(ls.equals(LunchStatus.ARCHIVED)){
                    this.status=ls.name();
                    return  true;
                }
        }
        return false;
    }

    //TODO
    @Override
    public String toString() {
        return "Lunch{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", deadline=" + deadline +
                ", expectedDelivery=" + expectedDelivery +
                ", restaurant=" + restaurant +
                ", lunchMaster=" + lunchMaster +
                ", orders=" + orders.toString() +
                '}';
    }

}
