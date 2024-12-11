package com.vitalii.practice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "roadworks")
public class Roadworks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "road_section", nullable = false)
    private String roadSection;

    @Column(name = "session_number", nullable = false)
    private Integer sessionNumber;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "contractor", nullable = false)
    private String contractor;

    @Column(name = "repair_type", nullable = false)
    private String repairType;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
