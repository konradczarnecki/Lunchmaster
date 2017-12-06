package com.lunchmaster.api.lunch.dto;


import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@Entity
@Table(name = "lunch")
public class Lunch implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LunchStatus status;

    @Column(name = "deadline")
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
    @JoinColumn(name = "lunch_id")
    private List<Order> orders;

    public Lunch() {
        this.status = LunchStatus.OPEN;
        this.orders = new LinkedList<>();
    }


    /* GETTERS/SETTERS */
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

    public LunchStatus getStatus() {
        return this.status;
    }

    public void setStatus(LunchStatus status) {
        changeStatus(status);
    }


    /* Status checkers */
    public boolean isOpen() {
        return this.status.equals(LunchStatus.OPEN);
    }

    public boolean isClosed() {
        return this.status.equals(LunchStatus.CLOSED);
    }

    public boolean isOrdered() {
        return this.status.equals(LunchStatus.ORDERED);
    }

    public boolean isDelivered() {
        return this.status.equals(LunchStatus.DELIVERED);
    }

    public boolean isArchived() {
        return this.status.equals(LunchStatus.ARCHIVED);
    }


    /* State machine */
    private boolean changeStatus(LunchStatus ls) {
        if (checkStatus(ls)) {
            this.status = ls;
            return true;
        }
        return false;
    }

    private boolean checkStatus(LunchStatus ls) {
        switch (this.status) {
            case OPEN:
                if (ls.equals(LunchStatus.CLOSED) || ls.equals(LunchStatus.OPEN)) {
                    return true;
                }
            case CLOSED:
                if (ls.equals(LunchStatus.OPEN)) {
                    return true;
                } else if (ls.equals(LunchStatus.ORDERED) && this.hasOrders()) {
                    return true;
                }
            case ORDERED:
                if (ls.equals(LunchStatus.DELIVERED)) {
                    return true;
                }
            case DELIVERED:
                //TODO: add '&& if all orders are settled'
                if (ls.equals(LunchStatus.ARCHIVED)) {
                    return true;
                }
        }
        return false;
    }

    public boolean hasOrders() {
        return this.orders.size() > 0;
    }


    public boolean open() {
        return changeStatus(LunchStatus.OPEN);
    }

    public boolean close() {
        return changeStatus(LunchStatus.CLOSED);
    }

    public boolean order() {
        return changeStatus(LunchStatus.ORDERED);
    }

    public boolean deliver() {
        return changeStatus(LunchStatus.DELIVERED);
    }

    public boolean archive() {
        return changeStatus(LunchStatus.ARCHIVED);
    }


    public boolean isAfterDeadline() {
        return this.deadline.getTime() < new Date().getTime();
    }

    public boolean canBeDeleted() {
        return !this.hasOrders() && (isOpen() || isClosed());
    }

    public boolean canChangeRestaurant(){
        return !this.hasOrders() && isOpen();
    }

    public boolean isInBillingPhase(){
        return isOrdered() || isDelivered() || isArchived();
    }

    /* utils */
    public void prolongDeadline(int minutes){
        this.deadline.setTime(this.deadline.getTime()+minutes*60*1000);
    }

}
