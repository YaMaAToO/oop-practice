package com.vitalii.practice.controller;

import com.vitalii.practice.entity.Roadworks;
import java.util.Map;
import com.vitalii.practice.dto.RoadworksDTO;
import com.vitalii.practice.service.RoadworksService;
import com.vitalii.practice.mapper.RoadworksMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roadworks")
public class RoadworksController {

    private final RoadworksService roadworksService;
    private final RoadworksMapper roadworksMapper;

    public RoadworksController(RoadworksService roadworksService, RoadworksMapper roadworksMapper) {
        this.roadworksService = roadworksService;
        this.roadworksMapper = roadworksMapper;
    }

    // Створення нових дорожніх робіт
    @PostMapping
    public ResponseEntity<RoadworksDTO> createRoadwork(
            @Valid @RequestBody RoadworksDTO roadworksDTO) {
        // Перетворюємо DTO в Entity і зберігаємо в базу даних
        Roadworks roadwork = roadworksMapper.toEntity(roadworksDTO);
        Roadworks savedRoadwork = roadworksService.create(roadwork);

        // Перетворюємо збережену сутність назад у DTO і повертаємо відповідь
        RoadworksDTO responseDTO = roadworksMapper.toDto(savedRoadwork);
        return ResponseEntity.ok(responseDTO);
    }

    // Отримання всіх дорожніх робіт
    @GetMapping
    public ResponseEntity<List<RoadworksDTO>> getAllRoadworks() {
        List<Roadworks> roadworks = roadworksService.getAll();
        List<RoadworksDTO> roadworksDTOs = roadworks.stream()
                .map(roadworksMapper::toDto)
                .toList();
        return ResponseEntity.ok(roadworksDTOs);
    }

    // Отримання дорожніх робіт, згрупованих по дням
    @GetMapping("/grouped-by-day")
    public ResponseEntity<Map<String, List<RoadworksDTO>>> getRoadworksGroupedByDay() {
        Map<String, List<RoadworksDTO>> groupedRoadworks = roadworksService.getRoadworksGroupedByDay();
        return ResponseEntity.ok(groupedRoadworks);
    }
}
