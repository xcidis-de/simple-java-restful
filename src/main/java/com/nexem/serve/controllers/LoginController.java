package com.nexem.serve.controllers;

import com.nexem.serve.utils.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        logger.info("{} = password = {}", username, password);
        return new Response(true, "200");
    }




}
