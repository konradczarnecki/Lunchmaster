package com.lunchmaster.api.lunch.service;

import com.lunchmaster.api.lunch.snapshot.LunchSnapshot;

public interface LunchSnapshotService {

    LunchSnapshot saveLunchSnapshot(LunchSnapshot snapshot);
}
