package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@JsonIdentityInfo(generator = PropertyGenerator.class,property = "travelPackageID")
public class TravelPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelPackageID;
	private String packageName;
	@OneToMany(mappedBy = "travelPackage")
	private List<Service> service;
	@OneToMany(mappedBy = "travelPackage")
	private List<Image> image;
	private String description;

	public int getTravelPackageID() {
		return travelPackageID;
	}

	public void setTravelPackageID(int travelPackageID) {
		this.travelPackageID = travelPackageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
