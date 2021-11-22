package com.schoolmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.schoolmanagement.entity.Book;
import com.schoolmanagement.entity.Teacher;
import com.schoolmanagement.repository.Book_repository;
import com.schoolmanagement.service.Book_service;

@Service
public class Book_serviceImpl implements Book_service {

	@Autowired
	private Book_repository repository;
	
	@Override
	public Book saveRecord(Book book) {
		// TODO Auto-generated method stub
		return repository.save(book);
	}

	@Override
	public Optional<Book> getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void DeletById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Book> findAllData() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
}
