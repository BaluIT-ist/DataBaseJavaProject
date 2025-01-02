package com.dan.green_energy.model.repository;

import com.dan.green_energy.model.entity.MainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainTypeRepository extends JpaRepository<MainType,Integer> {
}
