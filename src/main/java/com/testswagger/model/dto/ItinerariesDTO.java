package com.testswagger.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItinerariesDTO implements Serializable {
    @JsonProperty("flightSchedule")
    private List<ItineraryDTO> itineraries;
}
