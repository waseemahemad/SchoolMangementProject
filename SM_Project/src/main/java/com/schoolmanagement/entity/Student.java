package com.schoolmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Student_id;
	private String student_class;
	private String Student_name;
	private String Student_dob;
	private String Student_gender;
	private String father_name;
	private String mother_name;
	private String permanent_address;
	private String contacts_details;

	public Student() {
	}
	

	public Student( String student_class, String student_name, String student_dob, String student_gender,
			String father_name, String mother_name, String permanent_address, String contacts_details) {
		this.student_class = student_class;
		this.Student_name = student_name;
		this.Student_dob = student_dob;
		this.Student_gender = student_gender;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.permanent_address = permanent_address;
	this.contacts_details = contacts_details;
	}


	public int getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}

	public String getStudent_class() {
		return student_class;
	}

	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	public String getStudent_dob() {
		return Student_dob;
	}

	public void setStudent_dob(String student_dob) {
		Student_dob = student_dob;
	}

	public String getStudent_gender() {
		return Student_gender;
	}

	public void setStudent_gender(String student_gender) {
		Student_gender = student_gender;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getContacts_details() {
		return contacts_details;
	}

	public void setContacts_details(String contacts_details) {
		this.contacts_details = contacts_details;
	}

}
