package com.schoolmanagement.controller;

import com.schoolmanagement.entity.AuthRequest;
import com.schoolmanagement.entity.User;
import com.schoolmanagement.repository.UserRepository;
import com.schoolmanagement.util.JwtUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin
public class WelcomeController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getUsername()));
	}

	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) throws Exception {
		repository.save(user);
		return "Successfully Registerd  " + user.getName() + "!!!";
	}

	@GetMapping("/rabi")
	public List<User> rabi() {
		return repository.findAll();
	}


	@GetMapping("/")
	public String welcome() {
		return "Welcome to javatechie !!";
	}

	@GetMapping("/allUsers")
	public List<User> getUser() {
		return repository.findAll();
	}

}
