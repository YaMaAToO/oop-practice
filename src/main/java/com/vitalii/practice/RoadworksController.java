package com.vitalii.practice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roadworks")
public class RoadworksController {
    private final RoadworksService service;

    public RoadworksController(RoadworksService service) {
        this.service = service;
    }

    @GetMapping
    public List<Roadworks> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Roadworks getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Roadworks create(@RequestBody Roadworks roadwork) {
        return service.create(roadwork);
    }

    @PutMapping("/{id}")
    public Roadworks update(@PathVariable Long id, @RequestBody Roadworks roadwork) {
        return service.update(id, roadwork);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
