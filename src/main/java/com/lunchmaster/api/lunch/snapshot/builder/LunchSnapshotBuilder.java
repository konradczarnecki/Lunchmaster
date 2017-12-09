package com.lunchmaster.api.lunch.snapshot.builder;

import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.snapshot.LunchSnapshot;
import com.lunchmaster.api.lunch.snapshot.OrderSnapshot;
import com.lunchmaster.api.lunch.snapshot.RestaurantSnapshot;
import com.lunchmaster.api.lunch.snapshot.UserSnapshot;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class LunchSnapshotBuilder {

    public static LunchSnapshot buildSnapshot(Lunch lunch) {
        LunchSnapshot lunchSnapshot = new LunchSnapshot();
        lunchSnapshot.setLunchId(lunch.getId());
        lunchSnapshot.setDeadline(lunch.getDeadline());
        lunchSnapshot.setExpectedDelivery(lunch.getExpectedDelivery());
        lunchSnapshot.setRestaurant(LunchSnapshotBuilder.buildRestaurantSnapshot(lunch.getRestaurant()));
        lunchSnapshot.setLunchMaster(LunchSnapshotBuilder.buildUserSnapshot(lunch.getLunchMaster()));
        lunchSnapshot.setOrders(LunchSnapshotBuilder.buildOrdersSnapshots(lunch.getOrders()));

        return lunchSnapshot;
    }

    static RestaurantSnapshot buildRestaurantSnapshot(Restaurant restaurant) {
        RestaurantSnapshot restaurantSnapshot = new RestaurantSnapshot();
        restaurantSnapshot.setId(restaurant.getId());
        restaurantSnapshot.setName(restaurant.getName());
        restaurantSnapshot.setPhone(restaurant.getPhone());
        restaurantSnapshot.setAddress(restaurant.getAddress());
        restaurantSnapshot.setLink(restaurant.getLink());

        return restaurantSnapshot;
    }

    static UserSnapshot buildUserSnapshot(User user) {
        UserSnapshot userSnapshot = new UserSnapshot();
        userSnapshot.setId(user.getId());
        userSnapshot.setFirstName(user.getFirstName());
        userSnapshot.setLastName(user.getLastName());
        userSnapshot.setEmail(user.getEmail());
        userSnapshot.setBankAccount(user.getBankAccount());
        userSnapshot.setMobile(user.getMobile());

        return userSnapshot;
    }

    static List<OrderSnapshot> buildOrdersSnapshots(List<Order> orders) {
        List<OrderSnapshot> orderSnapshots = new LinkedList<>();

        for(Order order: orders) {
            OrderSnapshot orderSnapshot = new OrderSnapshot();
            orderSnapshot.setId(order.getId());
            orderSnapshot.setNote(order.getNote());
            orderSnapshot.setUser(LunchSnapshotBuilder.buildUserSnapshot(order.getUser()));
            orderSnapshot.setDishes(order.getDishes());

            orderSnapshots.add(orderSnapshot);
        }

        return orderSnapshots;
    }
}
