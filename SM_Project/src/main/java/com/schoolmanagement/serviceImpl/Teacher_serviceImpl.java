package com.schoolmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.Teacher;
import com.schoolmanagement.repository.Teacher_repo;
import com.schoolmanagement.service.teacher_service;

@Service
public class Teacher_serviceImpl implements teacher_service {

	@Autowired
	private Teacher_repo repository;

	@Override
	public Teacher saveRecord(Teacher teacher) {
		// TODO Auto-generated method stub
		return repository.save(teacher);
	}

	@Override
	public Optional<Teacher> getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void DeletById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Teacher> findAllData() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
