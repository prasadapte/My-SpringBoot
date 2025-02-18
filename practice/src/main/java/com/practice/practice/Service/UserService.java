package com.practice.practice.Service;

import java.util.List;

import com.practice.practice.Model.User;

public interface UserService {
	
	User createUser(User user);
	List<User> getAllUser();
	User getUserById(Long id);
	User updateUser(Long id,User user);
	void deleteUser(Long id);
	
}
