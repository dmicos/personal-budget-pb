package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Transaction;
import com.myfinance.personalbudget.dto.CsvDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    private final ModelMapper mapper;

    public DtoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public List<Transaction> toEntity(List<CsvDto> dtos) {
        return dtos.stream()
                .map(dto -> mapper.map(dto, Transaction.class))
                .collect(Collectors.toList());
    }
}
