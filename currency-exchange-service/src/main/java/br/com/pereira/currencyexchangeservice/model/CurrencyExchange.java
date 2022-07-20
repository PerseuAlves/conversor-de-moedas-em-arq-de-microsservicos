package br.com.pereira.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
	
	@Id
    @Column
    @GeneratedValue
	@EqualsAndHashCode.Include
	@NotNull
	private Long id;
	@Column(name = "currency_from")
	@NotBlank
	private String from;
	@Column(name = "currency_to")
	@NotBlank
	private String to;
	@NotNull
	private BigDecimal conversionMultiple;
	@NotBlank
	private String environment;
}
