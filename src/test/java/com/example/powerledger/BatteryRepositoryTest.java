package com.example.powerledger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.powerledger.repository.BatteryRepository;

@SpringBootTest
public class BatteryRepositoryTest {

	@Autowired
	BatteryRepository batteryRepository;

	@Test
	void saveAllTest() {
		assertEquals(BaseTest.listSize, batteryRepository.saveAll(BaseTest.createBatteryList()).size());
	}

	@Test
	void findByPostCodeRangeTest() {
		batteryRepository.saveAll(BaseTest.createBatteryList());
		assertEquals(3, batteryRepository.findByPostCodeRange(10, 30).size());
	}

}
