package com.schoolmanagement.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.serviceImpl.Student_serviceImpl;

@RestController
@RequestMapping("/rest/api/school")
@CrossOrigin("http://localhost:4200")
public class StudentController {

	@Autowired
	private Student_serviceImpl studentservice;

	@GetMapping
	public ResponseEntity<List<Student>> findAll() {
		return ResponseEntity.ok(studentservice.findAllData());
	}

	@PostMapping
	public ResponseEntity create(@RequestBody Student school) {
		return ResponseEntity.ok(studentservice.saveRecord(school));
	}

	@GetMapping("/{id}")
	public Optional<Student> getUserById(@PathVariable("id") int userId) {
		return studentservice.getById(userId);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
	    try {
	    	Optional<Student> existProduct = studentservice.getById(id);
	    	studentservice.saveRecord(student);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		try {
			studentservice.DeletById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException ex) {
			// log the error message
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
