package com.teamra.appwswhisper.application.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHome {
    
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
