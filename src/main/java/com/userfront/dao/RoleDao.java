package com.userfront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
