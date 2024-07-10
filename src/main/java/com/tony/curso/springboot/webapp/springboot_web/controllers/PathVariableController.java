package com.tony.curso.springboot.webapp.springboot_web.controllers;
import com.tony.curso.springboot.webapp.springboot_web.models.User;
import com.tony.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value ("${config.username}")
    private String username;

/*     @Value ("${config.message}")
    private String message;
 */
    @Value ("${config.listOfValues}")
    private List<String> listOfValues;
    
    @Value ("${config.code}")
    private Integer code;
    
    // Lenguaje de expresion
    @Value ("#{ '${config.listOfValues}'.toUpperCase().split(',') }")
    private List<String> valuesList;
    
    @Value ("#{ '${config.listOfValues}'.toUpperCase() }")
    private String valuesString;

    @Value ("#{ ${config.valuesMap} }")
    private Map<String, Object> valuesMap; 
    
    @Value ("#{ ${config.valuesMap}.product }")
    private String product; 
    
    @Value ("#{ ${config.valuesMap}.price }")
    private Integer price;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param; 
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(@PathVariable() String product, @PathVariable Integer id){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        Logger logger = Logger.getLogger("APP SPRING");
        user.setName(user.getName().toUpperCase());
        logger.info("User "+ user.getName() +" has been created");
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value ("${config.message}") String message){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", Integer.parseInt(environment.getProperty("config.code")));
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valuesList);
        json.put("valueString", valuesString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }

}
