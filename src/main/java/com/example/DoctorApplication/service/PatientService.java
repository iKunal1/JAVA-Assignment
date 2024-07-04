package com.example.DoctorApplication.service;

import com.example.DoctorApplication.entity.Patient;
import com.example.DoctorApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
}
