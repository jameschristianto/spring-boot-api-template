package com.simple.api.repository;

import com.simple.api.entity.CalculatorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends JpaRepository<CalculatorEntity, Long> {
    
}