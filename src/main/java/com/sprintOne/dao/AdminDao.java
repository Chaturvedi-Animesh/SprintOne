package com.sprintOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintOne.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
