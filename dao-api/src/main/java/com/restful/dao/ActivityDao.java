package com.restful.dao;

import com.restful.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Long> {
}
