package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "useq" ,sequenceName = "users_seq",initialValue = 101,allocationSize = 1)
public class User {
	
	@Id
	@GeneratedValue(generator = "useq",strategy = GenerationType.SEQUENCE)
	private int userId;
	
	@Column(length = 20)
	private String name;
	
	private int age;
	
	@Column(length = 10)
	private String gender;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 3)
	private String examTaken = "no";
	
	@Column
	private double percentScore;
	
	private void user() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getExamTaken() {
		return examTaken;
	}

	public void setExamTaken(String examTaken) {
		this.examTaken = examTaken;
	}

	public double getPercentScore() {
		return percentScore;
	}

	public void setPercentScore(double percentScore) {
		this.percentScore = percentScore;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", examTaken=" + examTaken + ", percentScore=" + percentScore + "]";
	}
	
}