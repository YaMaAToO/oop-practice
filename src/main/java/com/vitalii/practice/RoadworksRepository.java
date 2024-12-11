package com.vitalii.practice;

import com.vitalii.practice.entity.Roadworks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadworksRepository extends JpaRepository<Roadworks, Long> {
}
