package com.sprintOne.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.Tournament;

@Repository
public interface TournamentDao extends JpaRepository<Tournament, Integer> {

}
