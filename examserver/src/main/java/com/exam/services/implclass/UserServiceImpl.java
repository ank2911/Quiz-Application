package com.exam.services.implclass;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepo;
import com.exam.repository.UserRepo;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepo.findByUsername(user.getUsername());
        if(local!=null){
            throw new Exception("User already Exist!!");
        }else{
            for(UserRole ur:userRoles){
                this.roleRepo.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepo.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepo.deleteById(id);
    }
}
