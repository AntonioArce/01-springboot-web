package com.tony.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tony.curso.springboot.webapp.springboot_web.models.User;



@Controller // Componente: Objetos que se guardan en un contenedor
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Antonio","Arce");
        user.setEmail("tony260196@gmail.com");
        model.addAttribute("title", "Hola Mundo Springboot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String listUsers(ModelMap model) {
        model.addAttribute("title", "Lista de usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
            new User("pepa", "gonzalez"),
            new User("eri", "zavala", "eri@gmail.com"),
            new User("nayelhi", "romero"),
            new User("edosn", "mendoza")
        );
    }
    
    // Otra manera de insertar elementos a la vista
    /* public String otro(Map<String, Object> model){
        model.put("title", "Hola Mundo Springboot");
        model.put("name", "Antonio");
        model.put("lastname", "Arce");

        return "details";
    } */

}
