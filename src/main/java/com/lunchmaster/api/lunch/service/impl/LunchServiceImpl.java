package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */
@Service
public class LunchServiceImpl implements LunchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    private LunchDao dao;

    @Autowired
    public LunchServiceImpl(LunchDao lunchDao){
        this.dao = lunchDao;
    }

    public LunchServiceImpl(){}

    public List<Lunch> getLunches() {
        return dao.findAll();
    }

}

