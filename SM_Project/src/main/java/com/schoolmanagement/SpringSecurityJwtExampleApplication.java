package com.schoolmanagement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.User;
import com.schoolmanagement.repository.Student_repository;
import com.schoolmanagement.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;
    @Autowired
    private Student_repository studentrepo;
    /**
     * Insert/Load Data into H2 Database 
     */
    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "Rabi", "p", "djrabi@gmail.com"),
                new User(101, "waseem", "waseem", "waseem@gmail.com"),
                new User(102, "Roddur", "pwd1", "user1@gmail.com"),
                new User(103, "Baba", "pwd2", "user2@gmail.com"),
                new User(104, "Ma", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
        
        
        List<Student> student = Stream.of(
        		new Student("5th", "waseem", "12/2/1998", "male", "shaikh", "shaikh", "maharashtra", "9876543210"),
        		new Student("5th", "waseem", "12/2/1998", "male", "shaikh", "shaikh", "maharashtra", "9876543210")
        ).collect(Collectors.toList());
        studentrepo.saveAll(student);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
