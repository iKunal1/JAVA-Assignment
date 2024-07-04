package com.example.DoctorApplication.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = SymptomDeserializer.class)
public enum Symptom {
    SKIN_BURN,
    ARTHRITIS,
    DYSMENORRHEA,
    BACK_PAIN,
    TISSUE_INJURIES,
    SKIN_INFECTION,
    EAR_PAIN,
    UNKNOWN;

    public static Symptom fromString(String value) {
        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
