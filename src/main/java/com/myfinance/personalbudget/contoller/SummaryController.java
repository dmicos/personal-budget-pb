package com.myfinance.personalbudget.contoller;

import com.myfinance.personalbudget.repository.TransactionRepository;
import com.myfinance.personalbudget.repository.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SummaryController {
    private final TransactionRepository transactionRepository;

    @Autowired
    CounterpartyRepository counterpartyRepository;

    public SummaryController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/summary")
    public String getSummaryForm(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "summary";
    }

}