package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Here we need to define which MS are we calling using "Application"-name in app.properties
//Domain name URl  of the MS
@FeignClient(name="currency-exchange-service",url = "http://localhost:8000")
public interface CurrencyExchangeProxy {

	//Define the actual method we are using from this Currency Exchange MS
	//Note: We also change Return Type to "CurrencyConversion" from exchange
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	
	
}
