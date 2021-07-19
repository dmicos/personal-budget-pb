package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Pager;
import org.springframework.stereotype.Component;

@Component
public class PageService {

    public Pager getPeges(int totalPages, int currentPage, int buttonsRange) {
        int firstPageRange;
        int lastPageRange;

        validationIfEven(buttonsRange);
        int halfPagesToShow = buttonsRange / 2;

        if (totalPages <= buttonsRange) {
            firstPageRange = 1;
            lastPageRange = totalPages;
        } else if (currentPage - halfPagesToShow <= 0) {
            firstPageRange = 1;
            lastPageRange = buttonsRange;
        } else if (currentPage + halfPagesToShow == totalPages) {
            firstPageRange = currentPage - halfPagesToShow;
            lastPageRange = totalPages;
        } else if (currentPage + halfPagesToShow > totalPages) {
            firstPageRange = totalPages - buttonsRange + 1;
            lastPageRange = totalPages;
        } else {
            firstPageRange = currentPage - halfPagesToShow;
            lastPageRange = currentPage + halfPagesToShow;
        }

        return new Pager(firstPageRange, lastPageRange);
    }

    private void validationIfEven(int buttonsRange) {
        if (buttonsRange % 2 == 0) {
            throw new IllegalArgumentException("Must be even!");
        }
    }
}
