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
import java.util.List;

/**
 * Created by m.slefarski on 2017-11-24.
 */
@Component
public class ScheduledTasks {


    private LunchDao lunchDao;

    private static final int CLOSE_LUNCHES_MILLI = 10_000;
    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    @Autowired
    public ScheduledTasks(LunchDao lunchDao) {
        this.lunchDao = lunchDao;
    }

    /**
     * Close lunches with exceeded deadline.
     * delete enpty lunches
     * (delay since last completion of this task)
     */
    @Scheduled(fixedDelay = CLOSE_LUNCHES_MILLI)
    private void schedule_cleanLunches(){
        closeLunchesAfterDeadline();
        deleteEmptyLunches();
    }

    private void closeLunchesAfterDeadline() {
        //fetch all open lunches:
        List<Lunch> openLunches = this.lunchDao.getByStatus(LunchStatus.OPEN);
        List<Lunch> closedLunches = new ArrayList<>();

        //for all open lunches:
        for (Lunch lunch : openLunches) {
            if (lunch.isOpen() && lunch.isAfterDeadline()) {
                //close if deadline has passed
                lunch.close();
                closedLunches.add(lunch);
            }
        }
        //update only changed lunches
        this.lunchDao.save(closedLunches);
    }

    private void deleteEmptyLunches() {
        //fetch all open lunches:
        List<Lunch> closedLunches = this.lunchDao.getByStatus(LunchStatus.CLOSED);
        List<Lunch> toDeletion = new ArrayList<>();

        //for all closed lunches:
        for (Lunch lunch : closedLunches) {
            if (!lunch.hasOrders()) {
                toDeletion.add(lunch);
            }
        }
        //delete empty lunches
        this.lunchDao.delete(toDeletion);
    }



}
