package com.restful.service;

import com.restful.dao.ActivityDao;
import com.restful.model.Activity;
import com.restful.rest_controller.RestfulApiApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest(classes = RestfulApiApplication.class)
class ActivityServiceImplTest {

    private static final int ONCE = 1;
    private static final long TEST_ACTIVITY_ID = 1L;
    private static final String TEST_ACTIVITY_NAME = "TEST_NAME";
    private static Activity TEST_ACTIVITY;
    private static List<Activity> TEST_ACTIVITIES;

    @Mock
    private ActivityDao activityDao;

    private ActivityService activityService;

    @BeforeAll
    public static void setupActivities() {
        TEST_ACTIVITY = new Activity();
        TEST_ACTIVITY.setId(TEST_ACTIVITY_ID);
        TEST_ACTIVITY.setActivityName(TEST_ACTIVITY_NAME);
        TEST_ACTIVITIES = new ArrayList<>();
        TEST_ACTIVITIES.add(TEST_ACTIVITY);
    }

    @BeforeEach
    public void setup() {
        initMocks(this);
        activityService = new ActivityServiceImpl(activityDao);
    }

    @Test
    public void shouldReturnActivities() {
        when(activityDao.findAll()).thenReturn(TEST_ACTIVITIES);
        List<Activity> activities = activityService.getAllActivities();
        assertNotNull(activities);
        assertEquals(TEST_ACTIVITIES.size(), activities.size());
        verify(activityDao, times(ONCE)).findAll();
    }

    @Test
    public void shouldReturnActivityById() {
        when(activityDao.findById(TEST_ACTIVITY_ID)).thenReturn(Optional.of(TEST_ACTIVITY));
        Optional<Activity> activity = activityService.getActivityById(TEST_ACTIVITY_ID);
        assertNotNull(activity);
        verify(activityDao, times(ONCE)).findById(TEST_ACTIVITY_ID);
    }

    @Test
    public void shouldReturnActivityByName() {
        when(activityDao.findByActivityName(TEST_ACTIVITY_NAME)).thenReturn(Optional.of(TEST_ACTIVITY));
        Optional<Activity> activity = activityService.getActivityByName(TEST_ACTIVITY_NAME);
        assertNotNull(activity);
        verify(activityDao, times(ONCE)).findByActivityName(TEST_ACTIVITY_NAME);
    }

    @Test
    public void shouldSaveActivity() {
        when(activityDao.save(any(Activity.class))).thenReturn(TEST_ACTIVITY);
        activityService.saveOrUpdateActivity(TEST_ACTIVITY);
        verify(activityDao, times(ONCE)).save(TEST_ACTIVITY);
    }

    @Test
    public void shouldDeleteActivity() {
        doNothing().when(activityDao).deleteById(TEST_ACTIVITY_ID);
        activityService.deleteActivityById(TEST_ACTIVITY_ID);
        verify(activityDao, times(ONCE)).deleteById(TEST_ACTIVITY_ID);
    }
}