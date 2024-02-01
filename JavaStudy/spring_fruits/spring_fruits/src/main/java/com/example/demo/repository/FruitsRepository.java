package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FruitsEntity;

/**
 * 果物情報 Repository
 */
@Repository
public interface FruitsRepository extends JpaRepository<FruitsEntity, Integer> {
}