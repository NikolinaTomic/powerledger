package com.example.powerledger.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BatteryDTO {

	@NotBlank
	private String name;

	private int postcode;

	private int wattCapacity;

}
