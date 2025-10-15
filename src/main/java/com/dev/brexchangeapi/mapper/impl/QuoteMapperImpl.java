package com.dev.brexchangeapi.mapper.impl;

import com.dev.brexchangeapi.dto.QuoteDetailsDto;
import com.dev.brexchangeapi.mapper.QuoteMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuoteMapperImpl implements QuoteMapper {
    private ObjectMapper objectMapper = new ObjectMapper();
    private String jsonString;

    public QuoteDetailsDto processJson(String jsonString) throws Exception {
        try {
            Map<String, QuoteDetailsDto> responseMap = objectMapper.readValue(jsonString, new TypeReference<>() {});
            String currencyPair = responseMap.keySet().iterator().next();
            QuoteDetailsDto quoteDetailsDto = responseMap.get(currencyPair);
            return quoteDetailsDto;
        }catch (Exception e){
            throw new Exception("Erro ao processor JSON", e);
        }
    }

}
