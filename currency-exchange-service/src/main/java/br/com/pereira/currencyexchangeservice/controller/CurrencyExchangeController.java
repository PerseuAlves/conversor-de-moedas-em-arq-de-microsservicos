package br.com.pereira.currencyexchangeservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.pereira.currencyexchangeservice.model.CurrencyExchange;
import br.com.pereira.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		
		Optional<CurrencyExchange> currencyExchange = currencyExchangeService.findByFromAndTo(from, to);
		
		if(currencyExchange.isEmpty()) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to);
		} else {
			currencyExchange.get().setEnvironment(port);
			return currencyExchange.get();
		}		
	}
}
