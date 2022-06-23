package com.example.powerledger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.powerledger.model.entity.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {
	
	Optional<Battery> findById(Integer id);

}
