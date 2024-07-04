package com.example.DoctorApplication.controller;


import com.example.DoctorApplication.entity.City;
import com.example.DoctorApplication.entity.Doctor;
import com.example.DoctorApplication.entity.Patient;
import com.example.DoctorApplication.service.DoctorService;
import com.example.DoctorApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/suggest/{id}")
    public ResponseEntity<?> suggestDoctor(@PathVariable Long id) {
        Optional<Patient> patientOpt = patientService.getPatientById(id);
        if (!patientOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }

        Patient patient = patientOpt.get();
        List<Doctor> doctors = doctorService.suggestDoctors(patient);

        if (doctors.isEmpty()) {
            if (!EnumSet.of(City.DELHI, City.NOIDA, City.FARIDABAD).contains(City.valueOf(patient.getCity().toUpperCase()))) {
                return ResponseEntity.status(HttpStatus.OK).body("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("There isn’t any doctor present at your location for your symptom");
            }
        }
        return ResponseEntity.ok(doctors);
    }
}
