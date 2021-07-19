package com.myfinance.personalbudget.util.converter;

import com.opencsv.bean.AbstractBeanField;

public class DoubleConverter extends AbstractBeanField<Double> {

    @Override
    protected Double convert(String value) {
        return (value == null || value.isEmpty()) ? null : Double.parseDouble(value.replace(",", "."));
    }
}
