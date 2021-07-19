package com.myfinance.personalbudget.domain;

import lombok.*;

/**
 *  Store Range of buttons
 */

@Getter
@Setter
@AllArgsConstructor
public class Pager {
    private int firstPageRange;
    private int lastPageRange;
}