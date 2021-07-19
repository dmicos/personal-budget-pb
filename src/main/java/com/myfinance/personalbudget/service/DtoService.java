package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Transaction;
import com.myfinance.personalbudget.domain.Counterparty;
import com.myfinance.personalbudget.dto.CsvDto;
import com.myfinance.personalbudget.repository.TransactionRepository;
import com.myfinance.personalbudget.repository.CounterpartyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DtoService {
    private AtomicInteger countRecord = new AtomicInteger();
    private AtomicInteger duplicates = new AtomicInteger();

    private final TransactionRepository transactionRepository;
    private final CounterpartyRepository counterpartyRepository;
    private final DtoMapper mapper;

    public DtoService(TransactionRepository transactionRepository, CounterpartyRepository counterpartyRepository, DtoMapper mapper) {
        this.transactionRepository = transactionRepository;
        this.counterpartyRepository = counterpartyRepository;
        this.mapper = mapper;
    }

    @Transactional
    public void importToDb(List<CsvDto> csvDtos) {
        duplicates.set(0);
        countRecord.set(0);
        mapper.toEntity(csvDtos)
                .stream()
                .filter(transaction -> transaction.getTransactionNumber() != null)
                .forEach(transaction -> {
                    if (transactionRepository.existsById(transaction.getTransactionNumber())) {
                        duplicates.getAndIncrement();
                        return;
                    }
                    transactionRepository.save(updateCounterparty(transaction));
                    countRecord.getAndIncrement();
                });
    }

    private Transaction updateCounterparty(Transaction transaction) {
        Counterparty exist = counterpartyRepository.findOneByName(transaction.getCounterparty().getName());
        if (exist != null) {
            transaction.setCounterparty(exist);
        } else {
            transaction.setCounterparty(counterpartyRepository.save(transaction.getCounterparty()));
        }
        return transaction;
    }

    public Integer getCountRecord() {
        return countRecord.intValue();
    }

    public Integer getDuplicates() {
        return duplicates.intValue();
    }
}
