package com.schoolmanagement.service;

import java.util.List;
import java.util.Optional;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.Teacher;

public interface teacher_service {
	public Teacher saveRecord(Teacher school);

	public Optional<Teacher> getById(int id);

	void DeletById(int id);

	public List<Teacher> findAllData();
}
