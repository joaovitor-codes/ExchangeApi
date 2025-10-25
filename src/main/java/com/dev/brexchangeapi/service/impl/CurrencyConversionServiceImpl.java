package com.dev.brexchangeapi.service.impl;

import com.dev.brexchangeapi.service.CurrencyConversionService;
import com.dev.brexchangeapi.service.QuoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final QuoteService quoteService;

    public CurrencyConversionServiceImpl(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    public BigDecimal convertCurrency(String originCurrency, String destinationCurrency, BigDecimal amount) {
        return quoteService.seekQuote(originCurrency, destinationCurrency).multiply(amount);
    }
}
