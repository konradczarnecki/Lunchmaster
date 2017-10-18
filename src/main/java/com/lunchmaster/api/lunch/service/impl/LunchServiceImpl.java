package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */
@Service
public class LunchServiceImpl implements LunchService{


        @Autowired
        private LunchDao lunchDao;

        public List<Lunch> getLunches() {
            return lunchDao.findAll();
        }

}

