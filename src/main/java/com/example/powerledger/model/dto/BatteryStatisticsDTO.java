package com.example.powerledger.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class BatteryStatisticsDTO {
	
	private List<String> batteryNames;
	
	private int totalWattCapacity;
	
	private double averageWattCapacity;

}
