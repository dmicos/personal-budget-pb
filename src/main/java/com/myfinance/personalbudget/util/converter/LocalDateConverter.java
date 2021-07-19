package com.myfinance.personalbudget.util.converter;

import com.opencsv.bean.AbstractBeanField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends AbstractBeanField<LocalDate> {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected Object convert(String value) {
        return (value == null || value.isEmpty()) ? null : LocalDate.parse(value, FORMATTER);
    }
}