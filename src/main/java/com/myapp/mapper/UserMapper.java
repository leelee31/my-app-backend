package com.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.vo.User;

@Mapper
public interface UserMapper {
	List<User> userList();
	User fetchUserById(int id);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}
