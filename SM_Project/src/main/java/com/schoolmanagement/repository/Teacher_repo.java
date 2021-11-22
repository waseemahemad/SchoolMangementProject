package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.entity.Teacher;

public interface Teacher_repo extends JpaRepository<Teacher, Integer>{

}
