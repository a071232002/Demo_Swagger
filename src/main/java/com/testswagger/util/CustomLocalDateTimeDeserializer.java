package com.testswagger.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<String> {

    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    );

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
                return parsedDate.format(formatter);
            } catch (Exception e) {
                // continue to the next pattern
            }
        }
        throw new IOException("Unable to parse date: " + date);
    }
}
