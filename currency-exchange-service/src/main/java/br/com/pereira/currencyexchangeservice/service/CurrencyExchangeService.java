package br.com.pereira.currencyexchangeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pereira.currencyexchangeservice.model.CurrencyExchange;
import br.com.pereira.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public Optional<CurrencyExchange> findByFromAndTo(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}
}
