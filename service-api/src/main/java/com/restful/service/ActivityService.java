package com.restful.service;

import com.restful.model.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    List<Activity> getAllActivities();

    Activity saveOrUpdateActivity(Activity activity);

    Optional<Activity> getActivityByName(String activityName);

    Optional<Activity> getActivityById(Long activityId);

    void deleteActivityById(Long activityId);
}
