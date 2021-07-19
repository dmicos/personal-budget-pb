package com.myfinance.personalbudget.util.converter;

import com.myfinance.personalbudget.dto.CounterpartyDto;
import com.opencsv.bean.AbstractBeanField;

public class ToCounterpartyConverter extends AbstractBeanField {

    @Override
    protected Object convert(String value) {

        return (value == null || value.isEmpty()) ? null : new CounterpartyDto(value.trim());
    }
}
