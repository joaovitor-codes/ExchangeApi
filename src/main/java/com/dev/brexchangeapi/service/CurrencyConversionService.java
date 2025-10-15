package com.dev.brexchangeapi.service;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    BigDecimal convertCurrency(String originCurrency, String destinationCurrency, BigDecimal amount);
}
