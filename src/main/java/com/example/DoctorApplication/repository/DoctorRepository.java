package com.example.DoctorApplication.repository;


import com.example.DoctorApplication.entity.City;
import com.example.DoctorApplication.entity.Doctor;
import com.example.DoctorApplication.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}


