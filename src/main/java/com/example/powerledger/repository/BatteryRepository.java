package com.example.powerledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.powerledger.model.entity.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {

	@Query(value = "SELECT b FROM Battery b WHERE b.postcode BETWEEN :from and :to")
	List<Battery> findByPostCodeRange(@Param("from") int from, @Param("to") int to);

}
