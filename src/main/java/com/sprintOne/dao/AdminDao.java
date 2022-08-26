package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintOne.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

}
