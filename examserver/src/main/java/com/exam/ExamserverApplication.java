package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Code Running");
//        User user  = new User();
//        user.setFirstname("Ankit");
//        user.setLastname("Burman");
//        user.setUsername("ank939");
//        user.setEmail("abc@gmail.com");
//
//        Role role = new Role();
//        role.setRoleId(88L);
//        role.setRoleName("ADMIN");
//
//        Set<UserRole> set = new HashSet<>();
//        UserRole ur = new UserRole();
//        ur.setRole(role);
//        ur.setUser(user);
//        set.add(ur);
//        User u1 = this.userService.createUser(user,set);
//        System.out.println(u1.getUsername());
    }
}
