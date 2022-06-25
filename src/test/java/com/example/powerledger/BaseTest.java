package com.example.powerledger;

import java.util.ArrayList;
import java.util.List;

import com.example.powerledger.model.dto.BatteryDTO;
import com.example.powerledger.model.entity.Battery;

public class BaseTest {
	
	protected static int listSize = 5;

	protected static List<Battery> createBatteryList() {
		int i = 1;
		List<Battery> batteries = new ArrayList<>();
		while (i <= listSize) {
			batteries.add(Battery.builder()
					.id(i)
					.name("Battery" + i)
					.postcode(10 * i)
					.wattCapacity(10 * i)
					.build());
			i++;
		}
		return batteries;
	}
	
	protected static List<BatteryDTO> createBatteryDTOList() {
		int i = 1;
		List<BatteryDTO> batteriesDTO = new ArrayList<>();
		while (i <= listSize) {
			batteriesDTO.add(BatteryDTO.builder()
					.name("Battery" + i)
					.postcode(10 * i)
					.wattCapacity(10 * i)
					.build());
			i++;
		}
		return batteriesDTO;
	}
}
