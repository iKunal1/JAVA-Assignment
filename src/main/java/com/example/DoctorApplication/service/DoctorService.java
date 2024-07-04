package com.example.DoctorApplication.service;

import com.example.DoctorApplication.entity.*;
import com.example.DoctorApplication.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> suggestDoctors(Patient patient) {
        Speciality speciality = getSpecialityBySymptom(patient.getSymptom());
        if (speciality == null) {
            return Collections.emptyList();
        }
        return doctorRepository.findByCityAndSpeciality(City.valueOf(patient.getCity().toUpperCase()), speciality);
    }

    private Speciality getSpecialityBySymptom(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
            default -> null;
        };
    }
}
