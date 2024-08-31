package com.shoda.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoda.microservices.limits_service.bean.Limits;
import com.shoda.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {
	
	//Toget Configuration object
	@Autowired
	private Configuration configuration;

	@GetMapping(path="/limits")
	public Limits retrieveLimits()
	{	//Getting values from application.prop using @ConfigurationProperties- class 
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
		//return new Limits(1,1000);
	}
	
}
