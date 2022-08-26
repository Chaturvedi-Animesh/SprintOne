package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.TeamPointsTable;

@Repository
public interface TeamPointsTableDao extends JpaRepository<TeamPointsTable, Integer> {

}
