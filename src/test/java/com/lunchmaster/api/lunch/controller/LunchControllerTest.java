package com.lunchmaster.api.lunch.controller;

import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.login.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link com.lunchmaster.api.lunch.controller}
 * Created by Aleksander on 17.10.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(LunchController.class)
public class LunchControllerTest {

    private static final long MIDNIGHT_01_10_2017_EPOCH = 1506816000000L;
    private static final String LUNCH_CONTROLLER_URL = "/api/lunch",
                                LIST_ALL_LUNCHES_URL = LUNCH_CONTROLLER_URL + "/list";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LunchController lunchController;

    @MockBean
    private LunchService lunchService;

    @Test
    public void lunchController_isNotNull(){
        assertNotNull(lunchController);
    }

    @Test
    public void getLunches_LunchesFound_ShouldReturnFoundLunches() throws Exception {
        Lunch lunch = new Lunch();
        lunch.setId(1);
        lunch.setStatus("OPEN");
        lunch.setDeadline(Instant.ofEpochMilli(MIDNIGHT_01_10_2017_EPOCH).atZone(ZoneId.systemDefault()).toLocalDateTime());
        lunch.setExpectedDelivery(40);
        lunch.setRestaurant(new Restaurant());
        lunch.setLunchMaster(new User());
        lunch.setOrders(Collections.emptyList());

        when(lunchService.fetchLunches()).thenReturn(Arrays.asList(lunch));

        mvc.perform(get(LIST_ALL_LUNCHES_URL))
                .andExpect(
                        status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(
                        jsonPath("$", hasSize(1)))
                .andExpect(
                        jsonPath("$[0].id", is(1)))
                .andExpect(
                        jsonPath("$[0].status", is("OPEN")))
                .andExpect(
                        jsonPath("$[0].deadline", is(MIDNIGHT_01_10_2017_EPOCH)))
                .andExpect(
                        jsonPath("$[0].expectedDelivery", is(40)))
                .andExpect(
                        jsonPath("$[0].restaurant", notNullValue()))
                .andExpect(
                        jsonPath("$[0].lunchMaster", notNullValue()))
                .andExpect(
                        jsonPath("$[0].orders", notNullValue()));

    }

    @Test
    public void getLunches_NoLunchesFound_ShouldReturnEmptyArray() throws Exception {
        when(lunchService.fetchLunches()).thenReturn(Collections.emptyList());

        mvc.perform(get(LIST_ALL_LUNCHES_URL))
                .andExpect(
                        status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(
                        jsonPath("$", hasSize(0)));

    }

}
