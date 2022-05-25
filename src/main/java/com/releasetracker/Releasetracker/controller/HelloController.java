package com.releasetracker.Releasetracker.controller;


import com.releasetracker.Releasetracker.entity.ReleaseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Welcome to the release tracker application.";
    }
}
