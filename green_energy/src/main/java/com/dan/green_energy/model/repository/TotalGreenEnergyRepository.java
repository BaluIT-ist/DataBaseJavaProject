package com.dan.green_energy.model.repository;

import com.dan.green_energy.model.entity.TotalGreenEnergy;
import com.dan.green_energy.model.entity.id.TotalGreenEnergyID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalGreenEnergyRepository extends JpaRepository<TotalGreenEnergy, TotalGreenEnergyID> {
}