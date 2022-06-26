package com.example.powerledger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ValidationException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.powerledger.converter.BatteryConverter;
import com.example.powerledger.model.dto.BatteryDTO;
import com.example.powerledger.model.dto.BatteryStatisticsDTO;
import com.example.powerledger.model.entity.Battery;
import com.example.powerledger.repository.BatteryRepository;
import com.example.powerledger.service.BatteryService;

@SpringBootTest
public class BatteryServiceTest {

	@Mock
	BatteryRepository batteryRepository;

	@Mock
	BatteryConverter batteryConverter;

	@InjectMocks
	BatteryService batteryService;

	@Test
	void saveBatteryListTest() {
		when(batteryConverter.convertToEntity(any(BatteryDTO.class))).thenReturn(new Battery());
		when(batteryRepository.saveAll(anyList())).thenReturn(BaseTest.createBatteryList());
		assertEquals(BaseTest.listSize, batteryService.saveBatteryList(BaseTest.createBatteryDTOList()).size());
	}

	@Test
	void saveEmptyBatteryListTest() {
		List<BatteryDTO> batteriesDTO = new ArrayList<>();
		assertThat(batteryService.saveBatteryList(batteriesDTO)).isEmpty();
	}

	@Test
	void insertNullBatteryNameTest() {
		List<BatteryDTO> batteriesDTO = new ArrayList<>();
		batteriesDTO.add(new BatteryDTO(null, 10, 10));
		assertThrows(ValidationException.class, () -> batteryService.saveBatteryList(batteriesDTO));
	}

	@Test
	void getBatteryStatisticsTest() {
		when(batteryRepository.findByPostCodeRange(anyInt(), anyInt())).thenReturn(BaseTest.createBatteryList());

		BatteryStatisticsDTO statistics = batteryService.getBatteryStatistics(10, 50);

		assertEquals(BaseTest.listSize, statistics.getBatteryNames().size());
		assertEquals(150, statistics.getTotalWattCapacity());
		assertEquals(30.0, statistics.getAverageWattCapacity());
	}

	@Test
	void noBatteriesInRangeTest() {
		when(batteryRepository.findByPostCodeRange(anyInt(), anyInt())).thenReturn(new ArrayList<>());
		assertThrows(NoSuchElementException.class, () -> batteryService.getBatteryStatistics(10, 50));
	}

}
