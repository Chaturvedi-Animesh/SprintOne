package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.TeamDetails;

@Repository
public interface TeamDetailsDao extends JpaRepository<TeamDetails, Integer> {

}
