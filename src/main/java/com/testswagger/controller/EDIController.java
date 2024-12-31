package com.testswagger.controller;

import com.testswagger.model.dto.ItinerariesDTO;
import com.testswagger.model.dto.ItineraryDTO;
import com.testswagger.service.EdiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="EDITEST" )
public class EDIController {

    private final EdiService ediService;

    @PostMapping("/createEDIFACT")
    public String createEDIFACT (@RequestBody List<ItinerariesDTO> itinerariesDTOList) {
        String res = "";
        for (ItinerariesDTO itinerariesDTO : itinerariesDTOList) {
            for (ItineraryDTO itineraryDTO : itinerariesDTO.getItineraries()) {
                res = ediService.createEdi(itineraryDTO);
            }
        }
        return res;
    }

    @PostMapping("/formatEdifact")
    public String formatEdifact(@RequestBody String source) {
        String NEW_LINE = System.lineSeparator();
        return source.replace("'", "'" + NEW_LINE);
    }
}
