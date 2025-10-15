package com.dev.brexchangeapi.service.impl;

import com.dev.brexchangeapi.mapper.QuoteMapper;
import com.dev.brexchangeapi.service.CurrencyConversionService;
import com.dev.brexchangeapi.service.QuoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final QuoteService quoteService;

    public CurrencyConversionServiceImpl(QuoteService quoteService, QuoteMapper quoteMapper) {
        this.quoteService = quoteService;
    }

    public BigDecimal convertCurrency(String originCurrency, String destinationCurrency, BigDecimal amount) {
        BigDecimal seekQuote = quoteService.seekQuote(originCurrency, destinationCurrency);
        if (seekQuote != null) {
            return seekQuote.multiply(amount);
        }
        return null;
    }
}
