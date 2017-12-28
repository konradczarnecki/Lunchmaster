package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.lunch.dao.LunchSnapshotDao;
import com.lunchmaster.api.lunch.service.LunchSnapshotService;
import com.lunchmaster.api.lunch.snapshot.LunchSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoDBLunchSnapshotService implements LunchSnapshotService {

    private LunchSnapshotDao lunchSnapshotDao;

    @Autowired
    public MongoDBLunchSnapshotService(LunchSnapshotDao lunchSnapshotDao) {
        this.lunchSnapshotDao = lunchSnapshotDao;
    }

    @Override
    public LunchSnapshot saveLunchSnapshot(LunchSnapshot snapshot) {
        return lunchSnapshotDao.save(snapshot);
    }
}
