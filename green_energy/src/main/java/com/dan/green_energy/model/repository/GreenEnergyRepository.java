package com.dan.green_energy.model.repository;

import com.dan.green_energy.model.entity.GreenEnergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenEnergyRepository extends JpaRepository<GreenEnergy,Integer> {
}
