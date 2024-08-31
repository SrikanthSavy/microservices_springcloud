package com.shoda.microservices.limits_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component											//Spring application Context can manage it
@ConfigurationProperties("limits-service")			//To fetch values from application.prop with prefix: "limits-service"
public class Configuration {

	//Members should be same as 1) limits-service.minimum  	2)limits-service.maximum
	private int minimum;
	private int maximum;
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
	
}
