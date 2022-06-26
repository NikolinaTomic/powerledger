package com.example.powerledger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.powerledger.model.dto.BatteryDTO;
import com.example.powerledger.model.dto.BatteryStatisticsDTO;
import com.example.powerledger.service.BatteryService;

@RestController
@RequestMapping(value = "/battery")
public class BatteryController {

	@Autowired
	private BatteryService batteryService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> saveBatteryList(@RequestBody List<BatteryDTO> batteries) {
		return ResponseEntity
				.ok(String.format("%d new batteries saved.", batteryService.saveBatteryList(batteries).size()));
	}

	@GetMapping(value = "/getStatistics")
	public BatteryStatisticsDTO getBatteryStatistics(@RequestParam int from, @RequestParam int to) {
		return batteryService.getBatteryStatistics(from, to);
	}

}
