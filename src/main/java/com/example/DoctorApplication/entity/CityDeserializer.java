package com.example.DoctorApplication.entity;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CityDeserializer extends StdDeserializer<City> {

    public CityDeserializer() {
        this(null);
    }

    @Override
    public City deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return null;
    }

    protected CityDeserializer(Class<?> vc) {
        super(vc);
    }

   // @Override
    //public City deserialize(JsonNode jsonNode, DeserializationContext deserializationContext) throws IOException {        String cityValue = jsonNode.asText();        return City.fromString(cityValue);    }
}
