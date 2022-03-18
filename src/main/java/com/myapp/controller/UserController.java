package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.mapper.UserMapper;
import com.myapp.vo.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public List<User> userList() {
		System.out.println("================유저리스트 출력 성공 ");
		return userMapper.userList();
	}
	
	@PostMapping
	public void insertUser(@RequestBody User user) {
		userMapper.insertUser(user);
		System.out.println("================유저 추가 성공");

	}
	
	@GetMapping("/{id}")
	public User fetchUserById(@PathVariable int id) {
		return userMapper.fetchUserById(id);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User user) {
		User updateUser = User.builder()
							.userName(user.getUserName())
							.password(user.getPassword())
							.firstName(user.getFirstName())
							.lastName(user.getLastName())
							.age(user.getAge())
							.salary(user.getSalary())
							.build();

		userMapper.updateUser(updateUser);
		System.out.println("================유저 정보 갱신 성공");

	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userMapper.deleteUser(id);
		System.out.println("================유저 삭제 성공");
	}	
}
