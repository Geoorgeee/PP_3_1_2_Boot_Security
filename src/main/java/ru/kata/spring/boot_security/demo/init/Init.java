package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;

@Component
@Scope("prototype")
public class Init {
    private UserServiceImpl userService;

    @Autowired
    public Init(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void run() {
        Set<Role> adminRole = Collections.singleton(new Role("ROLE_ADMIN"));
        Set<Role> userRole = Collections.singleton(new Role("ROLE_USER"));
        User user1 = new User();
        user1.setPassword("100");
        user1.setRoles(adminRole);
        user1.setAge((byte) 10);
        user1.setUsername("jora");
        user1.setLastName("jora");
        User user2 = new User();
        user2.setPassword("100");
        user2.setRoles(userRole);
        user2.setAge((byte) 10);
        user2.setUsername("gowa");
        user2.setLastName("gowa");
        userService.addUser(user1);
        userService.addUser(user2);

    }
}