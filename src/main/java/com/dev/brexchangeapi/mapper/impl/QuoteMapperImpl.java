package com.dev.brexchangeapi.mapper.impl;

import com.dev.brexchangeapi.dto.ApiResponseDto;
import com.dev.brexchangeapi.dto.QuoteDetailsDto;
import com.dev.brexchangeapi.exceptions.ErrorExchangeNotFound;
import com.dev.brexchangeapi.exceptions.ErrorProcessingJson;
import com.dev.brexchangeapi.mapper.QuoteMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuoteMapperImpl implements QuoteMapper {
    private final ObjectMapper objectMapper;

    public QuoteMapperImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public QuoteDetailsDto processJson(String jsonString){
        try {
            TypeReference<Map<String, ApiResponseDto>> typeRef = new TypeReference<>() {};
            Map<String, ApiResponseDto> responseMap = objectMapper.readValue(jsonString, typeRef);

            ApiResponseDto apiResponse = responseMap.values().stream().findFirst()
                    .orElseThrow(() -> new ErrorExchangeNotFound("Nenhum dado de cambio encontrado na resposta da API"));

            if (apiResponse.bid() == null) {
                throw new ErrorExchangeNotFound("Nenhum dado de cambio encontrado na resposta da API");
            }

            return new QuoteDetailsDto(apiResponse.code(), apiResponse.bid());
        }catch (Exception e){
            throw new ErrorProcessingJson("Erro ao processor JSON");
        }
    }
}
