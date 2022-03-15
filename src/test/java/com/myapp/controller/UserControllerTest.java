package com.myapp.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.myapp.vo.User;

@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	UserController uc;
	
	@Test
	public void testInsertUser() {
		String userName = "wow";
		String password = "pwpw";
		String firstName = "test first name";
		String lastName = "test last name";
		int age = 30;
		int salary = 100;

		uc.insertUser(User.builder()
				.userName(userName)
				.password(password)
				.firstName(firstName)
				.lastName(lastName)
				.age(age)
				.salary(salary)
				.build());

		List<User> userList = uc.userList();

		User user = userList.get(0);
		System.out.println("user.getUserName(): " + user.getUserName());
		Assertions.assertThat(userName).isEqualTo(user.getUserName());
		Assertions.assertThat(password).isEqualTo(user.getPassword());
		Assertions.assertThat(firstName).isEqualTo(user.getFirstName());
		Assertions.assertThat(lastName).isEqualTo(user.getLastName());
		Assertions.assertThat(age).isEqualTo(user.getAge());
		Assertions.assertThat(salary).isEqualTo(user.getSalary());
	}
}
