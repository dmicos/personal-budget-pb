package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Counterparty;
import com.myfinance.personalbudget.repository.CounterpartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterpartyService {
    public final CounterpartyRepository counterpartyRepository;

    public CounterpartyService(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    public List<Counterparty> getCounterPartiesbyNameLike(String search){
        return counterpartyRepository.findAllByNameLike(search);
    }
}
