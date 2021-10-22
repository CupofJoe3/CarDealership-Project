package com.project2.Entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Cars {
	private int inventoryId;
	private String make;
	private String model;
	private int year;
	private boolean bidable;
	private String price;
	private String description;
	private String picLocation;
	private String miles;
	private LocalDate purchaseDate;
	private long daysBetween;
	private boolean used;
	private String discountedPrice;
	
	
	public Cars(boolean used, Integer inventoryId, String make, String model, int year, String price,
			String description, String picLocation, String miles, LocalDate purchaseDate) {
		this.used = used;
		this.inventoryId = inventoryId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.description = description;
		this.picLocation = picLocation;
		this.miles = miles;
		this.purchaseDate = purchaseDate;
	}
	public Cars() {
	}
	public String getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(String discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public long getDaysBetween() {
		long daysBetween = this.purchaseDate.until(LocalDate.now(), ChronoUnit.DAYS);
		this.daysBetween = daysBetween;
		return daysBetween;
	}
//	public void setDaysBetween() {
//		long daysBetween = this.purchaseDate.until(LocalDate.now(), ChronoUnit.DAYS);
//		this.daysBetween = daysBetween;
//	}
	public String getMiles() {
		return miles;
	}
	public void setMiles(String miles) {
		this.miles = miles;
	}
	public Integer getInventoryId() {
		return inventoryId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isBidable() {
		return bidable;
	}
	public void setBidable() {
		if(this.daysBetween < 120) {
			this.bidable = false;
		}
		else {
			this.bidable = true;
		}
		
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicLocation() {
		return picLocation;
	}
	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}
	
	
}
