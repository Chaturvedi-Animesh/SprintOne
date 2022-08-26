package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.MatchSchedule;

@Repository
public interface MatchScheduleDao extends JpaRepository<MatchSchedule, Integer> {

}
