package com.example.powerledger.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Battery {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer postcode;
	
	@Column
	private Integer watt_capacity;
	
}
