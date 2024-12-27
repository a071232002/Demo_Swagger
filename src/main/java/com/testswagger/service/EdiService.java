package com.testswagger.service;

import com.testswagger.model.dto.ItineraryDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EdiService {

    public String createEdi(ItineraryDTO itineraryDTO) {
        StringBuilder edifactBuilder = new StringBuilder();
        String newline = System.lineSeparator();
        String submittedDateTime = dateTimeConvert(itineraryDTO.getSubmittedDateTime());
        String airlineCode = itineraryDTO.getAirlineCode();
        String flightNumber = itineraryDTO.getFlightNumber();
        String portOfDisembarkation = itineraryDTO.getPortOfDisembarkation();
        String portOfEmbarkation = itineraryDTO.getPortOfEmbarkation();

        edifactBuilder.append("UNA:+.?*'")
                .append(newline);
        edifactBuilder.append("UNB+IATA:1+:" + airlineCode + "++" + submittedDateTime + "+3C8504E2A++PNRGOV'") //3C8504E2A 待解讀
                .append(newline);
        edifactBuilder.append("UNG+PNRGOV++PNRGOV+" + submittedDateTime + "+283697159+1A+15:1'") //283697159 EDIFACT REF待解讀
                .append(newline);
        edifactBuilder.append("UNH+1+PNRGOV:18:1:IA'")
                .append(newline);
        edifactBuilder.append("MSG+:22'")
                .append(newline);
        edifactBuilder.append("ORG+" + airlineCode + ":HAN'") //HAN 表示訊息生成地點, 可能是出發地或是航空公司總部(取得方式?)
                .append(newline);
        edifactBuilder.append(convertTVLLevel0(itineraryDTO)) // 時間格式ddmmyy:hhmm
                .append(newline);


        return edifactBuilder.toString();
    }

    public String dateTimeConvert(String targetDateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ISO_DATE_TIME);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyMMdd:HHmm"));
    }

    public String convertTVLLevel0(ItineraryDTO itineraryDTO) {

        String airlineCode = itineraryDTO.getAirlineCode();
        String flightNumber = itineraryDTO.getFlightNumber();
        String portOfDisembarkation = itineraryDTO.getPortOfDisembarkation();
        String portOfEmbarkation = itineraryDTO.getPortOfEmbarkation();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("TVL+171224:0755:171224:1316+" + portOfEmbarkation + "+" + portOfDisembarkation + "+" + airlineCode + "+" + flightNumber + "'");

        return resultBuilder.toString();
    }
}
