package com.exam.services;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    //For Creating a user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);

    public void deleteUser(Long id);
}
