package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.MatchSchedule;

public interface MatchScheduleDao extends JpaRepository<MatchSchedule, Integer> {

}
