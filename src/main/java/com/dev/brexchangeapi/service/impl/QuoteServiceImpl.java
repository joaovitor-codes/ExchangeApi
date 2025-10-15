package com.dev.brexchangeapi.service.impl;

import com.dev.brexchangeapi.config.AwesomeApi;
import com.dev.brexchangeapi.dto.QuoteDetailsDto;
import com.dev.brexchangeapi.mapper.QuoteMapper;
import com.dev.brexchangeapi.service.QuoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final AwesomeApi awesomeApi;
    private final QuoteMapper quoteMapper;

    public QuoteServiceImpl(AwesomeApi awesomeApi, QuoteMapper quoteMapper) {
        this.awesomeApi = awesomeApi;
        this.quoteMapper = quoteMapper;
    }

    public BigDecimal seekQuote(String originCurrency, String destinationCurrency) {
        String coinsCode = originCurrency + "-" + destinationCurrency;
        String quote = awesomeApi.seekQuote(coinsCode);

        if (quote == null) {
            return null;
        }

        try {
            QuoteDetailsDto quoteDetailsDto = quoteMapper.processJson(quote);
            return quoteDetailsDto.bid();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar a cotação", e);
        }
    }
}
