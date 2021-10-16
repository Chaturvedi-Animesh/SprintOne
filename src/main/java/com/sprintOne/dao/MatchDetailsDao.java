package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.MatchDetails;

@Repository
public interface MatchDetailsDao extends JpaRepository<MatchDetails, Integer> {

}
