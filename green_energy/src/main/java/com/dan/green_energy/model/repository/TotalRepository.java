package com.dan.green_energy.model.repository;

import com.dan.green_energy.model.entity.Total;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalRepository extends JpaRepository<Total,Integer> {
}
