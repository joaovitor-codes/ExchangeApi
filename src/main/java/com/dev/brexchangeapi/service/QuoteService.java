package com.dev.brexchangeapi.service;

import java.math.BigDecimal;

public interface QuoteService {
    BigDecimal seekQuote(String originCurrency, String destinationCurrency);
}
