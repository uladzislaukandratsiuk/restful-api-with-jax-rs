package com.restful.service;

import com.restful.dao.ActivityDao;
import com.restful.model.Activity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityDao activityDao;

    public ActivityServiceImpl(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    @Transactional
    public List<Activity> getAllActivities() {
        return activityDao.findAll();
    }

    @Override
    @Transactional
    public Activity saveOrUpdateActivity(Activity activity) {
        return activityDao.save(activity);
    }

    @Override
    @Transactional
    public Optional<Activity> getActivityByName(String activityName) {
        return activityDao.findByActivityName(activityName);
    }

    @Override
    @Transactional
    public Optional<Activity> getActivityById(Long activityId) {
        return activityDao.findById(activityId);
    }

    @Override
    @Transactional
    public void deleteActivityById(Long activityId) {
        activityDao.deleteById(activityId);
    }
}
