package com.myfinance.personalbudget.specification;

import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.domain.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;


public class TransactionSpecifications {

    public static Specification<Transaction> hasSubcategory(Subcategory subcategory) {
        return (transaction, query, cb) -> cb.equal(transaction.get("subcategory"), subcategory);
    }

    public static Specification<Transaction> hasDateBetween(LocalDate dateBefore, LocalDate dateAfter) {
        return (transaction, query, cb) -> cb.between(transaction.get("subcategory"), dateBefore, dateAfter);
    }

}
