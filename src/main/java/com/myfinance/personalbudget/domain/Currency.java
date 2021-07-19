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
@ToString
public class Currency {
    @Id
    private String iso;
    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;

    public Currency(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }
}
