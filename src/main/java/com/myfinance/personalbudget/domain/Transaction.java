package com.myfinance.personalbudget.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "transactions")
public class Transaction extends AbstractEntity {
    @Id
    private Long transactionNumber;
    private LocalDate transactionDate;
    private LocalDate accountingDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Counterparty counterparty;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String accountNumber;
    private String bankName;
    private String details;
    private Double amountTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Currency currencyTransaction;

//    private String currencyTransaction;
    private Double blockedAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Currency currencyBlocked;
//    private String currencyBlocked;
    private Double amountPayment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Currency currencyPayment;
//    private String currencyPayment;
    private Double balance;
    @NotBlank(message = "Title is mandatory")
    private String currencyBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Subcategory subcategory;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn
    private Set<Tag> tags = new HashSet<>();
}
