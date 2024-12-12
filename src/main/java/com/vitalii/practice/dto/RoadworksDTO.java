package com.vitalii.practice.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import jakarta.validation.Valid;

public class RoadworksDTO {

    @NotNull(message = "Road section is required")
    @Size(min = 3, max = 255, message = "Road section must be between 3 and 255 characters")
    private String roadSection;

    @NotNull(message = "Session number is required")
    @Min(value = 1, message = "Session number must be greater than 0")
    private Integer sessionNumber;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @NotNull(message = "Contractor is required")
    @Size(min = 3, max = 255, message = "Contractor must be between 3 and 255 characters")
    private String contractor;

    @NotNull(message = "Repair type is required")
    @Pattern(regexp = "^(Routine|Emergency|Upgrade)$", message = "Repair type must be one of: Routine, Emergency, Upgrade")
    private String repairType;


    public String getRoadSection() {
        return roadSection;
    }

    public void setRoadSection(String roadSection) {
        this.roadSection = roadSection;
    }

    public Integer getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }
}
