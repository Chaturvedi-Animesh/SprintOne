package com.sprintOne.dao;

import org.springframework.stereotype.Repository;

import com.sprintOne.model.Bidder;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BidderDao extends JpaRepository<Bidder, Integer> {

}
