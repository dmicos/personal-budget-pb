package com.myfinance.personalbudget.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "transactions")
public class Counterparty extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;
    @OneToMany(mappedBy = "counterparty", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Counterparty(String name) {
        this.name = name;
    }
}
