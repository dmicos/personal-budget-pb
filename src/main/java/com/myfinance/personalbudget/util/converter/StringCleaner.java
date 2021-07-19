package com.myfinance.personalbudget.util.converter;

import com.opencsv.bean.AbstractBeanField;

public class StringCleaner extends AbstractBeanField {

    @Override
    protected Object convert(String value) {
        return (value == null || value.isEmpty()) ? null : value.trim();
    }
}