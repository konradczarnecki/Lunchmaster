package com.lunchmaster.api.lunch.service;

import com.lunchmaster.api.lunch.dto.Lunch;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */
public interface LunchService {

     List<Lunch> getLunches();
}
