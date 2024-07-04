
package com.example.DoctorApplication.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CityDeserializer.class)
public enum City {
    DELHI,
    NOIDA,
    FARIDABAD,
    UNKNOWN;

    public static City fromString(String value) {
        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}


