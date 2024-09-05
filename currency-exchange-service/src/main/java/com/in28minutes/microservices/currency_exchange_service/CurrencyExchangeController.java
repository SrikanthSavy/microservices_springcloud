package com.in28minutes.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired       					//Getting Repository class to execute on CurrencyExchange entity
	private CurrencyExchangeRepository repository;

	@Autowired						
	private Environment environment;	// This is to get the current Server Port Note: Choose core-package
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		//Fetch from Table
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to); 
		//if not found
		if(currencyExchange==null)
			throw new RuntimeException("Unable to find from:"+from+" to:"+to);
		String port = environment.getProperty("local.server.port"); // To get th elocal Server Port
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
	
	
	
}
