package com.in28minutes.microservices.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	
	//To Use Feign Framework, lets inject Proxy
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	// new RestTemplate() implemntation
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		//The Parameters which we are passing in the URL -Rest Template , Should be passed as HashMap<Strng,String>
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		//RestTemplate - is used to call other MS URls - Length Process
		ResponseEntity<CurencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurencyConversion.class, uriVariables);
		
		//To get CurrencyConversion from Response, we use .getBody()
		CurencyConversion currencyConversion = responseEntity.getBody();

		return new CurencyConversion(2001L, from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment()+"-RestTemplate() ");
	}
	
	//Feign Implementation
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		//To get CurrencyConversion 
		CurencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurencyConversion(2001L, from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment()+"- Feign");
	}

}
