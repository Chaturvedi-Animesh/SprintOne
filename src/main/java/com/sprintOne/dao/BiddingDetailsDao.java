package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.BiddingDetails;

@Repository
public interface BiddingDetailsDao extends JpaRepository<BiddingDetails, Integer> {

}
