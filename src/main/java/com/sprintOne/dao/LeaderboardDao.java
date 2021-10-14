package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.Leaderboard;

public interface LeaderboardDao extends JpaRepository<Leaderboard, Integer> {

}
