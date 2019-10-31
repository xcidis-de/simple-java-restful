package com.nexem.serve.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController("/login")
public class LoginController {

    @RequestMapping("")
    public Response login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        return null;
    }




}
