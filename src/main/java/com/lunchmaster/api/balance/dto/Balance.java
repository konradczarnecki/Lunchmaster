package com.lunchmaster.api.balance.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by m.slefarski on 2017-12-28.
 */
public class Balance {

    private List<ThinOrder> orders_INeedToPay;

    private List<ThinOrder> orders_IMustGetPaid;

    public Balance() {
        this.orders_IMustGetPaid = new ArrayList<>();
        this.orders_INeedToPay = new ArrayList<>();
    }

    public List<ThinOrder> getOrders_INeedToPay() {
        return orders_INeedToPay;
    }

    public void setOrders_INeedToPay(List<ThinOrder> orders_INeedToPay) {
        this.orders_INeedToPay = orders_INeedToPay;
    }

    public List<ThinOrder> getOrders_IMustGetPaid() {
        return orders_IMustGetPaid;
    }

    public void setOrders_IMustGetPaid(List<ThinOrder> orders_IMustGetPaid) {
        this.orders_IMustGetPaid = orders_IMustGetPaid;
    }

    public static Balance getDummy(){

        //dish 1
        ThinDish td1 = new ThinDish();
        td1.setId(1);
        td1.setDishName("Kaczucha");
        td1.setPrice(18);

        //dish 2
        ThinDish td2 = new ThinDish();
        td2.setId(2);
        td2.setDishName("Makaron Chiński");
        td2.setPrice(14);

        //dish 2
        ThinDish td3 = new ThinDish();
        td3.setId(3);
        td3.setDishName("Kutiak w tietie na otro");
        td3.setPrice(15);

        //order 1
        ThinOrder to1 = new ThinOrder();
        to1.setId(1);
        to1.setUserId(2);
        to1.setUserFirstName("Jan");
        to1.setUserLastName("Kowalski");
        to1.setDate(new Date());
        to1.setLunchId(1);
        to1.setRestaurantName("Viet Thai");
        to1.getDishes().add(td1);
        to1.getDishes().add(td2);

        //order 1.2
        ThinOrder to12 = new ThinOrder();
        to12.setId(4);
        to12.setUserId(2);
        to12.setUserFirstName("Jan");
        to12.setUserLastName("Kowalski");
        to12.setDate(new Date());
        to12.setLunchId(4);
        to12.setRestaurantName("Viet Thai");
        to12.getDishes().add(td1);


        //order 1.3
        ThinOrder to13 = new ThinOrder();
        to13.setId(5);
        to13.setUserId(2);
        to13.setUserFirstName("Jan");
        to13.setUserLastName("Kowalski");
        to13.setDate(new Date());
        to13.setLunchId(5);
        to13.setRestaurantName("Viet Thai");
        to13.getDishes().add(td1);
        to13.getDishes().add(td2);
        to13.getDishes().add(td3);

        //order 2
        ThinOrder to2 = new ThinOrder();
        to2.setId(2);
        to2.setUserId(3);
        to2.setUserFirstName("Yolo");
        to2.setUserLastName("Yolo");
        to2.setDate(new Date());
        to2.setLunchId(2);
        to2.setRestaurantName("Viet Thai");
        to2.getDishes().add(td1);
        to2.getDishes().add(td3);

        //order 3
        ThinOrder to3 = new ThinOrder();
        to3.setId(3);
        to3.setUserId(4);
        to3.setUserFirstName("Janusz");
        to3.setUserLastName("Cebuliński");
        to3.setDate(new Date());
        to3.setLunchId(3);
        to3.setRestaurantName("Viet Thai");
        to3.getDishes().add(td3);

        //balance
        Balance balance = new Balance();
        balance.getOrders_IMustGetPaid().add(to1);
        balance.getOrders_IMustGetPaid().add(to12);
        balance.getOrders_IMustGetPaid().add(to13);
        balance.getOrders_INeedToPay().add(to2);
        balance.getOrders_INeedToPay().add(to3);

        return balance;

    }
}
