package com.vitalii.practice;

public class Roadworks {
    private String roadSection;
    private Integer sessionNumber;
    private LocalDate startDate;
    private String contractor;
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
