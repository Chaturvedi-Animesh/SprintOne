package com.sprintOne.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.Tournament;

public interface TournamentDao extends JpaRepository<Tournament, Integer> {

}
