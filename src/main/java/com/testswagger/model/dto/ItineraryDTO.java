package com.testswagger.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testswagger.util.CustomLocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ItineraryDTO implements Serializable {

    private String id;
    @JsonProperty("Flight reference")
    private String flightReference;
    @JsonProperty("cabinClass")
    @JsonAlias({"Cabin Class"})
    private String cabinClass;
    @JsonProperty("departureAirport")
    @JsonAlias("Departure Airport")
    private String portOfEmbarkation;
    @JsonProperty("arrivalAirport")
    @JsonAlias({"Arrive Airport"})
    private String portOfDisembarkation;
    @JsonProperty("departureTime")
    @JsonAlias({"Departure time", "departureTime"})
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private String departureDate;
    @JsonProperty("arrivalTime")
    @JsonAlias({"Arrival Time"})
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private String arrivalDate;
    @JsonProperty("seatNo")
    private String seatNumber;
    private String travellerType;
    private String pnrPassengerId;
    private String countryOfEmbarkation;
    private String countryOfDisembarkation;
    private String portOfEmbarkationFullName;
    private String portOfDisembarkationFullName;
    private String countryOfEmbarkationFullName;
    private String countryOfDisembarkationFullName;
    private String travellerTypeFullName;
    @JsonProperty("passenger")
    @JsonAlias({"passengers"})
    private List<PassengersDTO> passengers;
    @JsonProperty("airlineCode")
    @JsonAlias({"Airline Code"})
    private String airlineCode;
    @JsonProperty("flightNumber")
    @JsonAlias({"Flight No."})
    private String flightNumber;
    @JsonProperty("submittedDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String submittedDateTime;
}