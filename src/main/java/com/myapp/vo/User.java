package com.myapp.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private int salary;
	
	@Builder
	public User(String userName, String password, String firstName, String lastName, int age, int salary) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}
}
