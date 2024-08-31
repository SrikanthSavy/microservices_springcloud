package com.shoda.microservices.limits_service.bean;

public class Limits {
	private int minimum;
	private int maxmum;
	
	
	public Limits(int minimum, int maxmum) {
		super();
		this.minimum = minimum;
		this.maxmum = maxmum;
	}
	
	public Limits() {
		super();
	}

	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaxmum() {
		return maxmum;
	}
	public void setMaxmum(int maxmum) {
		this.maxmum = maxmum;
	}
	
	

}
