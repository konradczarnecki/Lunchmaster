package com.lunchmaster.api.lunch.snapshot;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Document(collection = "ordered_lunches")
public class LunchSnapshot {

    @Id
    @Field(value = "id")
    private String id;

    @Field(value = "lunch_id")
    private int lunchId;

    @Field(value = "deadline")
    private Date deadline;

    @Field(value = "expected_delivery")
    private int expectedDelivery;

    @Field(value = "restaurant")
    private RestaurantSnapshot restaurant;

    @Field(value = "lunch_master")
    private UserSnapshot lunchMaster;

    @Field(value = "lunch_orders")
    private List<OrderSnapshot> orders;

    public LunchSnapshot() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
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

    public RestaurantSnapshot getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantSnapshot restaurant) {
        this.restaurant = restaurant;
    }

    public UserSnapshot getLunchMaster() {
        return lunchMaster;
    }

    public void setLunchMaster(UserSnapshot lunchMaster) {
        this.lunchMaster = lunchMaster;
    }

    public List<OrderSnapshot> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSnapshot> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LunchSnapshot that = (LunchSnapshot) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LunchSnapshot{" +
                "id='" + id + '\'' +
                ", lunchId=" + lunchId +
                ", deadline=" + deadline +
                ", expectedDelivery=" + expectedDelivery +
                ", restaurant=" + restaurant +
                ", lunchMaster=" + lunchMaster +
                ", orders=" + orders +
                '}';
    }
}
