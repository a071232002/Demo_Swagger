package com.testswagger.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class PassengersDTO implements Serializable {

    private String id;
    @JsonProperty("firstGivenName")
    @JsonAlias({"First Name"})
    private String firstName;
    @JsonProperty("surName")
    @JsonAlias({"Last Name"})
    private String surname;
    @JsonProperty("Middle Name")
    private String otherNames;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("gender")
    @JsonAlias({"Gender"})
    private String gender;
    @JsonProperty("dateOfBirth")
    @JsonAlias({"Date of Birth", "DateofBirth"})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;
    private String travellerType;
    @JsonProperty("travelDocType")
    @JsonAlias({"Travel Doc. Type", "TravelDoc. Type"})
    private String travelDocType;
    @JsonProperty("issueCountry")
    @JsonAlias({"Issue Country"})
    private String travelDocCountry;
    @JsonProperty("travelDocNumber")
    @JsonAlias({"Travel Doc. No","TravelDoc. No"})
    private String travelDocNumber;
    @JsonProperty("expiryDate")
    @JsonAlias({"Expiry Date", "ExpiryDate"})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String travelDocExpiry;
    @JsonProperty("Flight reference")
    private String journeyReference;
    private String genderFullName;
    private String travellerTypeFullName;
    private String travellerDocTypeFullName;
    private String travellerDocCountryFullName;
    private String nationalityFullName;
    private String errorType;
    private String paxlstReference;
    private String content;
    private String countryOfEmbark;
    private String countryOfDisembark;
    private String portOfEmbark;
    private String portOfDisembark;
    private String bookingReference;
    @JsonProperty("seatNo")
    @JsonAlias({"Seat No."})
    private String seatNumber;
    private Integer checkedBags;
    private String bagTags;
    private String journeyReferenceId;
    private String portOfEmbarkFullname;
    private String portOfDisembarkFullname;
    private String countryOfEmbarkFullname;
    private String countryOfDisembarkFullname;
    private String uniqueReferenceId;
    private String contentId;
    private String operatorCode;
    private String operatorId;
    private Boolean isSubmitted;
    private String messageType;
    private String transmissionId;
    private String iapiTransmissionId;
    private String iapiResponse;
    private String iapiResponseStatus;
    private String submittedDateTime;
    private String clobTransmissionId;
    private String iapiResponseType;
    private String pnrTransmissionId;
    private Boolean isSaved;
    private String createdDateTime;
    private String residenceCountry;
    private String residenceCountryFullName;
    private String pnrRecordLocator;
    private String tripType;
    private String tripTypeFullName;
    @JsonProperty("phoneNumber")
    @JsonAlias({"PhoneNumber"})
    private String phoneNumber;
    @JsonProperty("emailAddress")
    @JsonAlias({"EmailAddress"})
    private String emailAddress;
    private String frequentFlyerOperator;
    private String frequentTravellerCode;
    private String frequentFlyerMembership;
    private String frequentFlyerOperatorName;
    private String travelAgencyIdentifier;
    private String travelAgencyName;
    private String travelAgencyPhone;
    private String travelAgencyStreetName;
    private String travelAgencyCity;
    private String travelAgencyPostalCode;
    private String travelAgencyCountry;
    private String travelAgencyCountryCode;
    private String billingPaymentDate;
    private String billingName;
    private String billingAddress;
    private String billingPaymentType;
    private String billingCreditCardNo;
    private String billingExpiry;
    @JsonProperty("cabinClass")
    @JsonAlias({"Cabin Class"})
    private String cabinClass;
}
