package com.myfinance.personalbudget.dto;

import com.myfinance.personalbudget.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CounterpartyDto {
    private Long id;
    private String name;
    private List<Transaction> transactions;

    public CounterpartyDto(String name) {
        this.name = name;
    }
}

