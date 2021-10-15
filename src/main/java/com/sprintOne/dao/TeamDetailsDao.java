package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.TeamDetails;

public interface TeamDetailsDao extends JpaRepository<TeamDetails, Integer> {

}
