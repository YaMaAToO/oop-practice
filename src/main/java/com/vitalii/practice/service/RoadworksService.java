package com.vitalii.practice.service;

import com.vitalii.practice.entity.Roadworks;
import com.vitalii.practice.RoadworksRepository;
import com.vitalii.practice.dto.RoadworksDTO;
import com.vitalii.practice.mapper.RoadworksMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoadworksService {
    private final RoadworksRepository repository;
    private final RoadworksMapper roadworksMapper;

    public RoadworksService(RoadworksRepository repository, RoadworksMapper roadworksMapper) {
        this.repository = repository;
        this.roadworksMapper = roadworksMapper;
    }

    public List<Roadworks> getAll() {
        return repository.findAll();
    }

    public Roadworks getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Roadworks create(Roadworks roadwork) {
        return repository.save(roadwork);
    }

    public Roadworks update(Long id, Roadworks roadwork) {
        Roadworks existing = getById(id);
        existing.setRoadSection(roadwork.getRoadSection());
        existing.setSessionNumber(roadwork.getSessionNumber());
        existing.setStartDate(roadwork.getStartDate());
        existing.setContractor(roadwork.getContractor());
        existing.setRepairType(roadwork.getRepairType());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Map<String, List<RoadworksDTO>> getRoadworksGroupedByDay() {
        List<Roadworks> roadworksList = repository.findAll();
        return roadworksList.stream()
                .map(roadworksMapper::toDto)
                .collect(Collectors.groupingBy(roadworksDTO -> roadworksDTO.getStartDate().toString()));
    }
}
