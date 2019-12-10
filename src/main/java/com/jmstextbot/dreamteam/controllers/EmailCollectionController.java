package com.jmstextbot.dreamteam.controllers;

import com.jmstextbot.dreamteam.entities.CustomerDriver;
import com.jmstextbot.dreamteam.repositories.CustomerDriverRepo;
import com.jmstextbot.dreamteam.utils.http.Response;
import com.jmstextbot.dreamteam.utils.http.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class EmailCollectionController {
    Logger logger = LoggerFactory.getLogger(EmailCollectionController.class);

    @Autowired
    private CustomerDriverRepo customerDriverRepo;

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/signup/email", method = RequestMethod.POST)
    public Response emailLogin(
            @RequestParam("email") String email) {
        logger.info("email = {}", email);
        if (email.isEmpty() || email.contains("@") != true) {
            return new Response("400");
        }

        CustomerDriver driver = new CustomerDriver(email, null, LocalDateTime.now());
        CustomerDriver customer = customerDriverRepo.insert(driver);
        if (customer.equals(null)) {
            return new Response("500");
        }
        return new Response("200");
    }

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/signup/phone", method = RequestMethod.POST)
    public Response phoneLogin(
            @RequestParam("phoneNumber") String phoneNumber) {
        logger.info("phone number = {}", phoneNumber);
        String phoneSimplified = simplePhoneNumber(phoneNumber);
        if (phoneNumber.isEmpty() || phoneNumber.equals(null)){
            return new Response("400");
        }

        CustomerDriver driver = new CustomerDriver(null, phoneSimplified, LocalDateTime.now());
        CustomerDriver customer = customerDriverRepo.insert(driver);
        if (customer.equals(null)) {
            return new Response("500");
        }
        return new Response("200");
    }


    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/signup/form", method = RequestMethod.POST)
    public Response login(
            @RequestParam("email") String email,
            @RequestParam("phoneNumber")  String phoneNumber,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("companyName") String companyName
            ) {

        if (email.isEmpty() || email.contains("@") == false) {
            return new Response("400");
        }
        if (phoneNumber.isEmpty() || phoneNumber.equals(null)){
            return new Response("400");
        }
        if (firstName.isEmpty() || firstName.equals(null)){
            return new Response("400");
        }
        if (lastName.isEmpty() || lastName.equals(null)){
            return new Response("400");
        }
        if (companyName.isEmpty() || companyName.equals(null)){
            return new Response("400");
        }
        CustomerDriver driver = new CustomerDriver(
                email,
                simplePhoneNumber(phoneNumber),
                firstName,
                lastName,
                companyName,
                LocalDateTime.now());

        CustomerDriver customer = customerDriverRepo.insert(driver);
        if (customer.equals(null)) {
            return new Response("500");
        }
        return new Response("200");
    }

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/signup/test", method = RequestMethod.GET)
    public Response test() {
        CustomerDriver customer = customerDriverRepo.insert(new CustomerDriver("xcidis.de@gmail.com", null, LocalDateTime.now()));
        if (customer.equals(null)) {
            return new Response("500");
        }
        return new Response("200");
    }

    protected String simplePhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll("[^\\d.]", "");
    }
}
