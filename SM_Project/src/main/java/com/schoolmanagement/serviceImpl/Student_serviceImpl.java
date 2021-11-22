package com.schoolmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.repository.Student_repository;
import com.schoolmanagement.service.Student_service;

@Service
public class Student_serviceImpl implements Student_service {

	@Autowired
	private Student_repository studentrepositriy;

	@Override
	public Student saveRecord(Student school) {
		// TODO Auto-generated method stub
        return studentrepositriy.save(school);
	}

	@Override
	public Optional<Student> getById(int id) {
		// TODO Auto-generated method stub
		return studentrepositriy.findById(id);
	}

	@Override
	public void DeletById(int id) {
		// TODO Auto-generated method stub
		studentrepositriy.deleteById(id);	
	}

	@Override
	public List<Student> findAllData() {
		// TODO Auto-generated method stub
		return (List<Student>) studentrepositriy.findAll();
	}


}
