package com.myfinance.personalbudget.dto;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.domain.Counterparty;
import com.myfinance.personalbudget.domain.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
    private Long transactionNumber;
    private LocalDate transactionDate;
    private Counterparty counterparty;
    private Double amountTransaction;
    private Subcategory subcategory;
    private Category category;
}
