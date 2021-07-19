package com.myfinance.personalbudget.dto;


import com.myfinance.personalbudget.util.converter.*;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CsvDto {
    @CsvCustomBindByName(column = "Data transakcji", converter = LocalDateConverter.class)
    private LocalDate transactionDate;
    @CsvCustomBindByName(column = "Data księgowania", converter = LocalDateConverter.class)
    private LocalDate accountingDate;
    @CsvCustomBindByName(column = "Dane kontrahenta", converter = ToCounterpartyConverter.class)
    private CounterpartyDto counterparty;
    @CsvCustomBindByName(column = "Tytuł", converter = StringCleaner.class)
    private String title;
    @CsvCustomBindByName(column = "Nr rachunku", converter = StringNumbersCleaner.class)
    private String accountNumber;
    @CsvBindByName(column = "Nazwa banku")
    private String bankName;
    @CsvBindByName(column = "Szczegóły")
    private String details;
    @CsvCustomBindByName(column = "Nr transakcji", converter = LongConverter.class)
    private Long transactionNumber;
    @CsvCustomBindByName(column = "Kwota transakcji (waluta rachunku)", converter = DoubleConverter.class)
    private Double amountTransaction;
    @CsvBindByName(column = "Waluta")
    private String currencyTransaction;
    @CsvCustomBindByName(column = "Kwota blokady/zwolnienie blokady", converter = DoubleConverter.class)
    private Double blockedAmount;
    @CsvBindByName(column = "Waluta")
    private String currencyBlocked;
    @CsvCustomBindByName(column = "Kwota płatności w walucie", converter = DoubleConverter.class)
    private Double amountPayment;
    @CsvBindByName(column = "Waluta")
    private String currencyPayment;
    @CsvCustomBindByName(column = "Saldo po transakcji", converter = DoubleConverter.class)
    private Double balance;
    @CsvBindByName(column = "Waluta")
    private String currencyBalance;
}
