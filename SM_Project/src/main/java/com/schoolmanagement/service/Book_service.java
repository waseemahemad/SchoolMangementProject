package com.schoolmanagement.service;

import java.util.List;
import java.util.Optional;

import com.schoolmanagement.entity.Book;
import com.schoolmanagement.entity.Teacher;

public interface Book_service {
	public Book saveRecord(Book book);

	public Optional<Book> getById(int id);

	void DeletById(int id);

	public List<Book> findAllData();
}
