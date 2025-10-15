package com.dev.brexchangeapi.controller;

import com.dev.brexchangeapi.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conversion")
public class ConversionController {
    private final CurrencyConversionService currencyConversionService;

    public ConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("{originCurrency}/{destinationCurrency}/{amount}")
    public ResponseEntity<BigDecimal> convertCurrency(@PathVariable String originCurrency, @PathVariable String destinationCurrency, @PathVariable BigDecimal amount) {
        BigDecimal convertedAmount = currencyConversionService.convertCurrency(originCurrency, destinationCurrency, amount);

        if (convertedAmount != null) {
            return ResponseEntity.ok(convertedAmount);
        }

        return ResponseEntity.notFound().build();
    }
}
