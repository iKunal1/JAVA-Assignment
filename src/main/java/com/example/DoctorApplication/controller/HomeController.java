package com.example.DoctorApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/add-patient")
    public String addPatient() {
        return "add-patient.html";
    }

    @GetMapping("/add-doctor")
    public String addDoctor() {
        return "add-doctor.html";
    }
}
