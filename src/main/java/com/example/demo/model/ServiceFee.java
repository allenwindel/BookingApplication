package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "serviceFeeID")
public class ServiceFee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceFeeID;
	private float amount;
	@ManyToOne
	private Service service;
	private String startDate;

	public int getServiceFeeID() {
		return serviceFeeID;
	}

	public void setServiceFeeID(int serviceFeeID) {
		this.serviceFeeID = serviceFeeID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
