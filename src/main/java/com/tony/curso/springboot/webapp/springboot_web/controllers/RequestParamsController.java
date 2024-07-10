package com.tony.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tony.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.tony.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(
        required = false, 
        defaultValue = "No hay mensaje en el params") 
        String message) {
        ParamDto param = new ParamDto();
        param.setMessage( message );  
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam Integer code) {
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request ){
        Integer code = 10;
        String message = "No hay mensaje en la request";
        try {
            code = Integer.parseInt(request.getParameter("code"));
            message = request.getParameter("message");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(message);
        return params;
    }
}
