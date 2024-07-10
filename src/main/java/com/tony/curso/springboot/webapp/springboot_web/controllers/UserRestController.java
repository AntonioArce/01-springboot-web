package com.tony.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

/* import java.util.HashMap;
import java.util.Map; */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tony.curso.springboot.webapp.springboot_web.models.User;
import com.tony.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
/* import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; */


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Antonio","Arce");

        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring");
        return userDto;
    }

    @GetMapping("/users")
    public List<User> list(){
        User user = new User("Antonio","Arce");
        User user1 = new User("Ericka","Zavala");
        User user2 = new User("edson","mendoza");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        return users;
    }


    /* @GetMapping("/details")
    public Map<String, Object> details(){
        User user = new User("Antonio","Arce");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Springboot");
        body.put("user", user);

        user.hola();

        return body;
    } */
}
