package com.example.powerledger.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.powerledger.converter.BatteryConverter;
import com.example.powerledger.model.dto.BatteryDTO;
import com.example.powerledger.model.dto.BatteryStatisticsDTO;
import com.example.powerledger.model.entity.Battery;
import com.example.powerledger.repository.BatteryRepository;

@Service
public class BatteryService {

	@Autowired
	private BatteryRepository batteryRepository;
	
	@Autowired
	private BatteryConverter batteryConverter;
	
	public void saveBatteries(List<BatteryDTO> batteriesDTO) {
		batteriesDTO.stream()
			.map(batteryDTO -> batteryConverter.convertToEntity(batteryDTO))
			.forEach(batteryRepository::save);			
	}
	
	public BatteryStatisticsDTO getBatteryStatistics(int from, int to) {
		List<Battery> batteryList = batteryRepository.findByPostCodeRange(from, to);

		BatteryStatisticsDTO statistics = new BatteryStatisticsDTO();
		
		statistics.setBatteryNames(batteryList.stream()
			.sorted(Comparator.comparing(Battery::getName))
			.map(battery -> battery.getName())
			.collect(Collectors.toList()));
		
		int totalWattCapacity = batteryList.stream()
			.map(battery -> battery.getWattCapacity())
			.collect(Collectors.summingInt(Integer::intValue));
		
		statistics.setTotalWattCapacity(totalWattCapacity);

		statistics.setAverageWattCapacity(totalWattCapacity/batteryList.size());
		
		return statistics;
	}

}
