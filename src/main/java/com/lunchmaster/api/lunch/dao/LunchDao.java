package com.lunchmaster.api.lunch.dao;

import com.lunchmaster.api.lunch.dto.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by m.slefarski on 2017-10-05.
 */

public interface LunchDao extends JpaRepository<Lunch, Integer> {

    List<Lunch> findAll();
}