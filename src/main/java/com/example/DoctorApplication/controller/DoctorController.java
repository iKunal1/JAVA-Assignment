package com.example.DoctorApplication.controller;


import com.example.DoctorApplication.entity.Doctor;
import com.example.DoctorApplication.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }
}


