package com.example.DoctorApplication.entity;




import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    @Email
    private String email;

    @Size(min = 10)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // Getters and setters

}


