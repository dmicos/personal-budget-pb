package com.myfinance.personalbudget.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;
    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();
}
