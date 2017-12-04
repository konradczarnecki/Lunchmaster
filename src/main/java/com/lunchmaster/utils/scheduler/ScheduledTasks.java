package com.lunchmaster.utils.scheduler;

import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.LunchStatus;
import com.lunchmaster.api.lunch.service.impl.LunchServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by m.slefarski on 2017-11-24.
 */
@Component
public class ScheduledTasks {


    private LunchDao lunchDao;

    private static final int CLOSE_LUNCHES_MILI = 10000; //10 seconds
    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    @Autowired
    public ScheduledTasks(LunchDao lunchDao) {
        this.lunchDao = lunchDao;
    }


    /**
     * Close lunches with exceeded deadline
     * with delay since last completion of this task in miliseconds.
     */
    @Scheduled(fixedDelay = CLOSE_LUNCHES_MILI)
    private void closeLunchesAfterDeadline() {
        //fetch all open lunches:
        List<Lunch> openLunches = this.lunchDao.getByStatus(LunchStatus.OPEN);
        List<Lunch> closedLunches = new ArrayList<>();
        long now = new Date().getTime();

        //for all open lunches:
        for (Lunch lunch : openLunches) {
            if (lunch.getStatus().equals(LunchStatus.OPEN)) {
                //close if deadline has passed or deadline is now
                if (lunch.getDeadline().getTime() <= now) {
                    lunch.changeStatus(LunchStatus.CLOSED);
                    closedLunches.add(lunch);
                }
            }
        }
        //update only changed lunches
        this.lunchDao.save(closedLunches);
        //log activity
        LOGGER.info("SCHEDULER: CLOSED " + closedLunches.size() + " lunches.");
    }
}
