package br.com.pereira.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pereira.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {
	
	Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
