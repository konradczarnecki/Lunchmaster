package com.lunchmaster.api.lunch.dao;

import com.lunchmaster.api.lunch.dto.LunchStatus;
import com.lunchmaster.api.lunch.dto.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by m.slefarski on 2017-10-05.
 */

public interface LunchDao extends JpaRepository<Lunch, Integer> {

    @Transactional(readOnly = true)
    List<Lunch> findAll();

    @Transactional(readOnly = true)
    Lunch getById(int id);

    @Transactional(readOnly = true)
    List<Lunch> getByStatus(String status);

    @Transactional
    Lunch save(Lunch lunch);

    @Transactional
    void deleteById(int id);

}