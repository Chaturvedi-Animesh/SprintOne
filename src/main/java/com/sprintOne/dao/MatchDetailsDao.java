package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.MatchDetails;

public interface MatchDetailsDao extends JpaRepository<MatchDetails, Integer> {

}
