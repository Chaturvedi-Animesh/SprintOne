package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.Leaderboard;

@Repository
public interface LeaderboardDao extends JpaRepository<Leaderboard, Integer> {

}
