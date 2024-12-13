package com.vitalii.practice.mapper;

import com.vitalii.practice.dto.RoadworksDTO;
import com.vitalii.practice.entity.Roadworks;
import org.springframework.stereotype.Component;

@Component
public class RoadworksMapper {

    public Roadworks toEntity(RoadworksDTO dto) {
        Roadworks entity = new Roadworks();
        entity.setRoadSection(dto.getRoadSection());
        entity.setSessionNumber(dto.getSessionNumber());
        entity.setStartDate(dto.getStartDate());
        entity.setContractor(dto.getContractor());
        entity.setRepairType(dto.getRepairType());
        return entity;
    }

    public RoadworksDTO toDto(Roadworks entity) {
        RoadworksDTO dto = new RoadworksDTO();
        dto.setRoadSection(entity.getRoadSection());
        dto.setSessionNumber(entity.getSessionNumber());
        dto.setStartDate(entity.getStartDate());
        dto.setContractor(entity.getContractor());
        dto.setRepairType(entity.getRepairType());
        return dto;
    }
}
