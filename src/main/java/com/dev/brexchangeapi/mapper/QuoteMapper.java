package com.dev.brexchangeapi.mapper;

import com.dev.brexchangeapi.dto.QuoteDetailsDto;

public interface QuoteMapper {
    QuoteDetailsDto processJson(String jsonString) throws Exception;
}
