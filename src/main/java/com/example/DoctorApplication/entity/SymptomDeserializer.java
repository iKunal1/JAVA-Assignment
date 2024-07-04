package com.example.DoctorApplication.entity;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SymptomDeserializer extends JsonDeserializer<Symptom> {

    @Override
    public Symptom deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String symptomValue = jsonParser.getText();
        return Symptom.fromString(symptomValue);
    }
}
