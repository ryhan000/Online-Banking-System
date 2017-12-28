package com.userFront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userFront.dao.UserDao;
import com.userFront.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		// TODO Auto-generated method stub
		if (checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkUsernameExists(String username) {
		// TODO Auto-generated method stub
		if (null != findByUsername(username)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkEmailExists(String email) {
		// TODO Auto-generated method stub
		if (null != findByEmail(email)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void save(User user) {

		userDao.save(user);
	}

}
