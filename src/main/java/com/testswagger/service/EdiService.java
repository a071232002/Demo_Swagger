package com.testswagger.service;

import com.testswagger.model.dto.ItineraryDTO;
import com.testswagger.model.dto.PassengersDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EdiService {

    private final static String NEW_LINE = System.lineSeparator();
    private final static String PUSH_PNR = "MSG+:22'";
    private static int msgRowCount = 0;

    public String createEdi(ItineraryDTO itineraryDTO) {
        StringBuilder edifactBuilder = new StringBuilder();

        edifactBuilder.append(writeUNA());
        edifactBuilder.append(writeUNB(itineraryDTO));
        edifactBuilder.append(writeUNG(itineraryDTO));
        edifactBuilder.append(writeUNH());
        edifactBuilder.append(writeMSG(PUSH_PNR));
        edifactBuilder.append(wirteORG(itineraryDTO));
        edifactBuilder.append(wirteTVLLevel0(itineraryDTO));
        edifactBuilder.append(wirteEQNLevel0(itineraryDTO));
        edifactBuilder.append(wirtePNRMessages(itineraryDTO.getPassengers()));
        edifactBuilder.append(writeUNT(msgRowCount));
        edifactBuilder.append(writeUNE());
        edifactBuilder.append(writeUNZ());

        System.out.println(edifactBuilder);
        return edifactBuilder.toString();
    }

    public String writeUNA(){
        StringBuilder sb = new StringBuilder();
        sb.append("UNA:+.?*'");
        sb.append(lineBreak());
        return sb.toString();
    }

    public String writeUNB(ItineraryDTO itineraryDTO){
        StringBuilder sb = new StringBuilder();
        String airlineCode = itineraryDTO.getAirlineCode();
        String submittedDateTime = dateTimeConvert(itineraryDTO.getSubmittedDateTime(), DateTimeFormatter.ISO_DATE_TIME, "yyMMdd:HHmm");
        //TODO "283697159" an..14 INTERCHANGE CONTROL REFERENCE 可與UNG REF不同 待解析
        sb.append("UNB+IATA:1+:" + airlineCode + "++" + submittedDateTime + "+283697159++PNRGOV'");
        sb.append(lineBreak());
        return sb.toString();
    }

    public String writeUNG(ItineraryDTO itineraryDTO){
        StringBuilder sb = new StringBuilder();
        String submittedDateTime = dateTimeConvert(itineraryDTO.getSubmittedDateTime(), DateTimeFormatter.ISO_DATE_TIME, "yyMMdd:HHmm");
        //TODO 283697159 an..14 MESSAGE REFERENCE NUMBER 待解析
        sb.append("UNG+PNRGOV++PNRGOV+" + submittedDateTime + "+283697159+1A+15:1'");
        sb.append(lineBreak());
        return sb.toString();
    }

    public String writeUNH(){
        StringBuilder sb = new StringBuilder();
        sb.append("UNH+1+PNRGOV:18:1:IA'");
        sb.append(lineBreak());
        return sb.toString();
    }

    public String writeMSG(String purpose){
        StringBuilder sb = new StringBuilder();
        sb.append(purpose);
        sb.append(lineBreak());
        return sb.toString();
    }

    public String wirteORG(ItineraryDTO itineraryDTO){
        StringBuilder sb = new StringBuilder();
        String airlineCode = itineraryDTO.getAirlineCode();
        //TODO USA 表示訊息生成地點, 可能是出發地或是航空公司總部(取得方式?)
        sb.append("ORG+" + airlineCode + ":USA'");
        sb.append(lineBreak());
        return sb.toString();
    }

    public String wirteTVLLevel0(ItineraryDTO itineraryDTO){
        StringBuilder sb = new StringBuilder();
        String airlineCode = itineraryDTO.getAirlineCode();
        String flightNumber = itineraryDTO.getFlightNumber();
        String portOfDisembarkation = itineraryDTO.getPortOfDisembarkation();
        String portOfEmbarkation = itineraryDTO.getPortOfEmbarkation();
        String departureDate = dateTimeConvert(itineraryDTO.getDepartureDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"), "ddMMyy:HHmm");
        String arrivalDate = dateTimeConvert(itineraryDTO.getArrivalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"), "ddMMyy:HHmm");

        // 時間格式ddMMyy:HHmm
        sb.append("TVL+" + departureDate + ":" + arrivalDate + "+" + portOfEmbarkation + "+" + portOfDisembarkation + "+" + airlineCode + "+" + flightNumber + "'")
                .append(lineBreak());
        return sb.toString();
    }

    public String wirteEQNLevel0(ItineraryDTO itineraryDTO){
        StringBuilder sb = new StringBuilder();
        int passengersNum = itineraryDTO.getPassengers().size();
        sb.append("EQN+" + passengersNum + "+'")
                .append(lineBreak());
        return sb.toString();
    }

    public String wirtePNRMessages(List<PassengersDTO> passengersDTOList){
        if (passengersDTOList.isEmpty())
            return lineBreak();

        StringBuilder sb = new StringBuilder();
        for (PassengersDTO passengersDTO : passengersDTOList) {

        }
        return "";
    }



    // UNT UNE(optional) UNZ EDIFACT REF must be same with UNG(e.g. 283697159)
    public String writeUNT(int msgRowCount){
        StringBuilder sb = new StringBuilder();
        //TODO 段落數計算邏輯數待釐清 (e.g. EQN=121,total row=4345, display only 3658)
        msgRowCount += 3;
        sb.append("UNE+" + msgRowCount + "+283697159'");
        sb.append(NEW_LINE);
        return sb.toString();
    }

    public String writeUNE(){
        StringBuilder sb = new StringBuilder();
        sb.append("UNT+1+283697159'");
        sb.append(NEW_LINE);
        return sb.toString();
    }
    // 根據guide理論上應和UNB REF相同, 但guide範例也只有對應UNG
    public String writeUNZ(){
        StringBuilder sb = new StringBuilder();
        sb.append("UNZ+1+283697159'");
        return sb.toString();
    }

    public String lineBreak(){
        msgRowCount++;
        return NEW_LINE;
    }

    public String dateTimeConvert(String targetDateTime, DateTimeFormatter inputPattern, String outputPattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(targetDateTime, inputPattern);
        return localDateTime.format(DateTimeFormatter.ofPattern(outputPattern));
    }

}
