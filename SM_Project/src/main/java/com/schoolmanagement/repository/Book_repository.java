package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.entity.Book;

public interface Book_repository extends JpaRepository<Book, Integer>{

}
