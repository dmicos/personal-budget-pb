package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.domain.Counterparty;
import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.domain.Transaction;
import com.myfinance.personalbudget.dto.TransactionDto;
import com.myfinance.personalbudget.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final SubCategoryService subCategoryService;
    private final CategoryService categoryService;
    private final CounterpartyService counterpartyService;


    private HashMap<String, Double> incomeExpenses = new HashMap<>();

    public HashMap<String, Double> getIncomeExpenses() {
        if (!incomeExpenses.isEmpty()){
            if (incomeExpenses.get("expenses")==null){incomeExpenses.put("expenses", 0.0);}
            if (incomeExpenses.get("income")==null){incomeExpenses.put("income", 0.0);}
            double expenses = Math.abs(incomeExpenses.get("expenses"));
            double income = incomeExpenses.get("income");
            double sum = expenses + income;
            incomeExpenses.put("widthForExpenses", (double) Math.round(expenses*100/sum));
            incomeExpenses.put("widthForIncome", (double) Math.round(income*100/sum));
            incomeExpenses.put("income", (double) Math.round(income * 100) / 100);
            incomeExpenses.put("expenses", (double) Math.round(expenses * 100) / 100);
        }
        return incomeExpenses;
    }

    public TransactionService(TransactionRepository transactionRepository, SubCategoryService subCategoryService, CategoryService categoryService, CounterpartyService counterpartyService) {
        this.transactionRepository = transactionRepository;
        this.subCategoryService = subCategoryService;
        this.categoryService = categoryService;
        this.counterpartyService = counterpartyService;
    }

    public Page<TransactionDto> getAllPageable(Pageable pageable, Long categoryId, Long subcategoryId, LocalDate dateStart, LocalDate dateEnd) {
        Page<Transaction> transactions;
        if ((dateEnd != null) && (dateStart != null) && (subcategoryId != null)) {
            Subcategory subcategory = subCategoryService.getSubcateoryById(subcategoryId);
            transactions = transactionRepository.findBySubcategoryAndTransactionDateBetweenOrderByTransactionDateDesc(pageable, subcategory, dateStart, dateEnd);
        } else {
            if ((dateEnd != null) && (dateStart != null)) {
                transactions = transactionRepository.findByTransactionDateBetweenOrderByTransactionDateDesc(pageable, dateStart, dateEnd);
                incomeExpenses.put("income", transactionRepository.calcSumIncomeByDate(dateStart, dateEnd));
                incomeExpenses.put("expenses", transactionRepository.calcSumExpensesByDate(dateStart, dateEnd));
            } else {
                if ((subcategoryId != null) && (categoryId != null)) {
                    Subcategory subcategory = subCategoryService.getSubcateoryById(subcategoryId);
                    Category category = categoryService.getCategoryByid(categoryId);
                    transactions = transactionRepository.findByCategoryAndSubcategoryOrderByTransactionDateDesc(pageable, category, subcategory);
                } else {
                    if (subcategoryId != null) {
                        Subcategory subcategory = subCategoryService.getSubcateoryById(subcategoryId);
                        transactions = transactionRepository.findBySubcategoryOrderByTransactionDateDesc(pageable, subcategory);
                    } else {
                        if (categoryId != null) {
                            Category category = categoryService.getCategoryByid(categoryId);
                            transactions = transactionRepository.findByCategoryOrderByTransactionDateDesc(pageable, category);
                        } else {
                            transactions = transactionRepository.findByOrderByTransactionDateDesc(pageable);
                            incomeExpenses.put("income", transactionRepository.calcSumIncome());
                            incomeExpenses.put("expenses", transactionRepository.calcSumExpenses());
                        }
                    }
                }
            }
        }
        return new PageImpl<>(TransactionConverter(transactions.getContent()), pageable, transactions.getTotalElements());
    }

    public Page<TransactionDto> getAllPageable(Pageable pageable, String search) {
        List<Counterparty> counterPartiesByNameLike = counterpartyService.getCounterPartiesbyNameLike(search);
        Page<Transaction> transactions  = transactionRepository.findByCounterpartyIn(pageable, counterPartiesByNameLike);
        return new PageImpl<>(TransactionConverter(transactions.getContent()), pageable, transactions.getTotalElements());
    }

    private List<TransactionDto> TransactionConverter(List<Transaction> content) {
        return content.stream().map(transaction -> new TransactionDto(
                transaction.getTransactionNumber(),
                transaction.getTransactionDate(),
                transaction.getCounterparty(),
                transaction.getAmountTransaction(),
                transaction.getSubcategory(),
                transaction.getCategory()
        )).collect(Collectors.toList());
    }

    public Transaction getByNumber(Long number) {
        return transactionRepository.findById(number).orElseThrow(() ->
                new EntityNotFoundException("Transactrion with number " + number + " was not found"));
    }

    public void setSubcategoryForTransaction(Long number, Subcategory subcategory) {
        Category category = subCategoryService.getSubcateoryById(subcategory.getId()).getCategory();
        transactionRepository.updateSubcategory(number, subcategory);
        transactionRepository.updateCategory(number, category);
    }

//    public Long getIncomeExpenses(){
//        AtomicReference<Double> expenses= new AtomicReference<>(0.0);
//        AtomicReference<Double> income= new AtomicReference<>(0.0);
//        getTransactionsList().forEach(transaction -> {
//            if (transaction.getAmountTransaction()>0){
//                expenses.set(expenses.get() + transaction.getAmountTransaction());
//            } else {
//                income.set(income.get() + transaction.getAmountTransaction());
//            }
//        });
//    }

//    public List<Transaction> findBySubcategory(Subcategory subcategory) {
//        return transactionRepository.findAll(hasSubcategory(subcategory));
//    }

}
