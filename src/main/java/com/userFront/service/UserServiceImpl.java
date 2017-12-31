package com.userFront.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userFront.dao.RoleDao;
import com.userFront.dao.UserDao;
import com.userFront.domain.User;
import com.userFront.security.domain.UserRole;


@Transactional
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	 
    @Autowired
    private AccountService accountService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {

		userDao.save(user);
	}


    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleDao.save(ur.getRole());
                
           }

            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);
        }

        return localUser;
    }

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

}
