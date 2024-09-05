package com.in28minutes.microservices.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	// Method to return a record based on "from " & "to" passed i.e. 'USD' to 'INR'
	public CurrencyExchange findByFromAndTo(String from, String to);

}
