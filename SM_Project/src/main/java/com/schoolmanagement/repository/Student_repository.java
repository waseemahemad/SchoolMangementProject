package com.schoolmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entity.Student;

@Repository
public interface Student_repository extends CrudRepository<Student, Integer> {



}
