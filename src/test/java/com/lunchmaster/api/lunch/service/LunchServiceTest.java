package com.lunchmaster.api.lunch.service;

/**
 * Created by m.slefarski on 2017-10-18.
 */

import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.service.impl.LunchServiceImpl;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.login.dto.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class LunchServiceTest {

    @TestConfiguration
    static class LunchServiceImpl_TestConfiguration {

        @Bean
        public LunchService lunchService() {
            return new LunchServiceImpl();
        }
    }

        @Autowired
        private LunchService lunchService;

        @MockBean
        private LunchDao dao;

        private Lunch lunch;


        @Before
        public void setup(){

            //init Lunch object
            lunch = new Lunch();
            lunch.setRestaurant(new Restaurant());
            lunch.setOrders(new ArrayList<Order>());
            lunch.setLunchMaster(new User());
            lunch.setStatus("TEST");
            lunch.setDeadline(new Date());
            lunch. setExpectedDelivery(1000);

            List<Lunch> lunches = Collections.singletonList(lunch);
            Mockito.when(dao.findAll()).thenReturn(lunches);
        }

        @Ignore
        @Test
        public void whenFingAll_thenLunchesShouldBeFound(){

            List<Lunch> lunches = lunchService.getLunches();

            //returned array shoud be the same and not changed
            assertThat(lunches.size()).isEqualTo(1);
            assertThat(lunches.get(0)).isEqualTo(lunch);

        }

}
