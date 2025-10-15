package com.dev.brexchangeapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuoteDetailsDto(String name, BigDecimal bid) {
}
