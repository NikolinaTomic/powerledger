package com.example.powerledger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.powerledger.repository.BatteryRepository;

@Service
public class BatteryService {

	@Autowired
	private BatteryRepository batteryRepository;

}
