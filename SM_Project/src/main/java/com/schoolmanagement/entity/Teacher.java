package com.schoolmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String teacher_name;
	private String teacher_specification;
	private String Teacher_contacts;
	private String Teacher_address;

	public Teacher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_specification() {
		return teacher_specification;
	}

	public void setTeacher_specification(String teacher_specification) {
		this.teacher_specification = teacher_specification;
	}

	public String getTeacher_contacts() {
		return Teacher_contacts;
	}

	public void setTeacher_contacts(String teacher_contacts) {
		Teacher_contacts = teacher_contacts;
	}

	public String getTeacher_address() {
		return Teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		Teacher_address = teacher_address;
	}

}
