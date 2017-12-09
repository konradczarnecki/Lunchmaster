package com.lunchmaster.api.lunch.dao;

import com.lunchmaster.api.lunch.snapshot.LunchSnapshot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LunchSnapshotDao extends MongoRepository<LunchSnapshot, String> {
}
