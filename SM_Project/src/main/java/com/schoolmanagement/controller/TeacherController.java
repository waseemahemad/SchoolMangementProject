package com.schoolmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.Teacher;
import com.schoolmanagement.serviceImpl.Teacher_serviceImpl;

@RestController
@RequestMapping("/rest/api/teacher/")
@CrossOrigin("http://localhost:4200")
public class TeacherController {
	
	@Autowired
	private Teacher_serviceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll() {
		return ResponseEntity.ok(service.findAllData());
	}

	@PostMapping
	public ResponseEntity create(@RequestBody Teacher teacher) {
		return ResponseEntity.ok(service.saveRecord(teacher));
	}

	@GetMapping("/{id}")
	public Optional<Teacher> getUserById(@PathVariable("id") int userId) {
		return service.getById(userId);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		try {
			service.DeletById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException ex) {
			// log the error message
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
