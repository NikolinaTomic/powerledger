package com.example.powerledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.powerledger.service.BatteryService;

@RestController
@RequestMapping(value = "battery")
public class BatteryController {

	@Autowired
	private BatteryService batteryService;
	
}
