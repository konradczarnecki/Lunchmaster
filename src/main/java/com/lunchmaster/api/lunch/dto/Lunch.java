package com.lunchmaster.api.lunch.dto;


import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.login.dto.User;
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
public class Lunch implements Serializable{

    /**
     * LUNCH STATUS
     * NOTE: BELOW DESCRIPTION IS NOT FINAL BY ANY MEANS! IT SHOULD BE DISCUSSED IN DETAIL)
     *
     * State machine is quite simple: OPEN -> CLOSED -> DELIVERED -> ARCHIVED
     * All other changes are forbidden and must be restricted by a proper state machine
     *
     * Lunch status description:
     *
     * @OPEN
     * newly created lunch that is open for orders!
     *
     * @CLOSED
     * lunch that is after deadline and orders cannot be placed or edited.
     * This state if from deadline to the moment of food arival.
     *
     * @DELIVERED
     * Food is here! Lunchmaster closes lunch, lunch participants are recieving email/sms.
     * Now (or rather after lunch :) is the time for all billing operations.
     *
     * At this moment under the hood lunch becomes a 'snapshot' in MongoDB
     * to prevent all price changes on orders. After successful transfer lunch is being
     * removed from MySQL.
     *
     * Everything except billing options are disabled.
     *
     * @ARCHIEVED
     * All payments are settled. Lunch becomes uneditable and
     * as a snapshot lands in the Mongo archive collection... FOREVER :)
     */
    private enum LunchStatus {OPEN, CLOSED, ORDERED, ARCHIVED}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
