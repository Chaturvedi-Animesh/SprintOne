package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.TeamPointsTable;

public interface TeamPointsTableDao extends JpaRepository<TeamPointsTable, Integer> {

}
