package com.myfinance.personalbudget.repository;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.domain.Counterparty;
import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    Page<Transaction> findBySubcategoryOrderByTransactionDateDesc(Pageable pageable, Subcategory subcategory);

    Page<Transaction> findByCategoryAndSubcategoryOrderByTransactionDateDesc(Pageable pageable, Category category, Subcategory subcategory);

    Page<Transaction> findByCategoryOrderByTransactionDateDesc(Pageable pageable, Category category);

    Page<Transaction> findBySubcategoryAndTransactionDateBetweenOrderByTransactionDateDesc(Pageable pageable, Subcategory subcategory, LocalDate dateStart, LocalDate dateEnd);

    Page<Transaction> findByTransactionDateBetweenOrderByTransactionDateDesc(Pageable pageable, LocalDate dateStart, LocalDate dateEnd);

    Page<Transaction> findByOrderByTransactionDateDesc(Pageable pageable);

    List<Transaction> findAllByTransactionDate(LocalDate transactionDate);

    Page<Transaction> findByCounterpartyIn(Pageable pageable, List<Counterparty> counterparties);

    List<Transaction> findAllByTransactionDateBetween(
            LocalDate transactionDateStart,
            LocalDate transactionDateEnd);

    @Modifying
    @Query("UPDATE Transaction t SET t.subcategory = :subcategory WHERE t.transactionNumber = :number")
    int updateSubcategory(@Param("number") Long number, @Param("subcategory") Subcategory subcategory);

    @Modifying
    @Query("UPDATE Transaction t SET t.category = :category WHERE t.transactionNumber = :number")
    int updateCategory(@Param("number") Long number, @Param("category") Category category);

    List<Transaction> findByTransactionDateBetween(LocalDate dateStart, LocalDate dateEnd);

    @Query("SELECT SUM(t.amountTransaction) FROM Transaction t WHERE t.amountTransaction < 0")
    Double calcSumExpenses();
    @Query("SELECT SUM(t.amountTransaction) FROM Transaction t WHERE t.amountTransaction > 0")
    Double calcSumIncome();

    @Query("SELECT SUM(t.amountTransaction) FROM Transaction t WHERE t.amountTransaction < 0 and t.transactionDate BETWEEN :dateStart and :dateEnd")
    Double calcSumExpensesByDate(LocalDate dateStart, LocalDate dateEnd);
    @Query("SELECT SUM(t.amountTransaction) FROM Transaction t WHERE t.amountTransaction > 0 and t.transactionDate BETWEEN :dateStart and :dateEnd")
    Double calcSumIncomeByDate(LocalDate dateStart, LocalDate dateEnd);
}
