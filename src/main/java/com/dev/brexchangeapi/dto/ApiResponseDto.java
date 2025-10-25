package com.dev.brexchangeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ApiResponseDto(
        String code,
        String codein,
        String name,
        BigDecimal high,
        BigDecimal low,
        BigDecimal varBid,
        BigDecimal pctChange,
        BigDecimal bid,
        BigDecimal ask,
        Long timestamp,
        @JsonProperty("create_date")
        String createDate
) {
}
