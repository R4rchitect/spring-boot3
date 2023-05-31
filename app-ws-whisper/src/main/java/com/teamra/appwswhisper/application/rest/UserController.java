package com.teamra.appwswhisper.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamra.appwswhisper.domain.users.model.User;
import com.teamra.appwswhisper.domain.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/find/{id}")
    User findUserById(@PathVariable final Integer id) {
        logger.info("Initializr @GetMapping -> findUserById");
        logger.info("ID: "+ id);
        return userService.findUserById(id);
    }
    
    
}
