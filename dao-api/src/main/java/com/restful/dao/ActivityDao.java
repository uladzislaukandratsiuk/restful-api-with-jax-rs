package com.restful.dao;

import com.restful.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Long> {

    Optional<Activity> findByActivityName(String activityName);
}
