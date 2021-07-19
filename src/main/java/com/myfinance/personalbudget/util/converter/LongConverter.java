package com.myfinance.personalbudget.util.converter;

import com.opencsv.bean.AbstractBeanField;
import org.springframework.util.NumberUtils;

import java.math.BigInteger;

public class LongConverter extends AbstractBeanField {

    @Override
    protected Long convert(String value) {
        return (value == null || value.isEmpty()) ? null :
                NumberUtils.parseNumber(value.replaceAll("'",""), Long.class);
    }
}
