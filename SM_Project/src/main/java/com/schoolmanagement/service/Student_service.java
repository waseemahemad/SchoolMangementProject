package com.schoolmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.schoolmanagement.entity.Student;

public interface Student_service {

	public Student saveRecord(Student school);

	public Optional<Student> getById(int id);

	void DeletById(int id);

	public List<Student> findAllData();
}
