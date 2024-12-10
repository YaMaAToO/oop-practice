package com.vitalii.practice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadworksService {
    private final RoadworksRepository repository;

    public RoadworksService(RoadworksRepository repository) {
        this.repository = repository;
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
}
