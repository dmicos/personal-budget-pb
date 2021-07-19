package com.myfinance.personalbudget.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "transactions")
public class Subcategory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    @Size(min = 2, max = 30)
    @NotBlank(message = "Title is mandatory")
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
