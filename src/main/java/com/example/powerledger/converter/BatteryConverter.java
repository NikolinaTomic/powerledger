package com.example.powerledger.converter;

import org.springframework.stereotype.Component;

import com.example.powerledger.model.dto.BatteryDTO;
import com.example.powerledger.model.entity.Battery;

@Component
public class BatteryConverter {

	public Battery convertToEntity(BatteryDTO dto) {
		return Battery.builder().name(dto.getName()).postcode(dto.getPostcode()).wattCapacity(dto.getWattCapacity())
				.build();
	}

	public BatteryDTO convertToDTO(Battery entity) {
		return BatteryDTO.builder().name(entity.getName()).postcode(entity.getPostcode())
				.wattCapacity(entity.getWattCapacity()).build();
	}

}
