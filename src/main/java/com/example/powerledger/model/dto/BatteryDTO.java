package com.example.powerledger.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BatteryDTO {
	
	@NotBlank
	private String name;
	
	private int postcode;

	private int wattCapacity;

}
