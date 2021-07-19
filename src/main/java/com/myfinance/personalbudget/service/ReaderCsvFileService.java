package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.dto.CsvDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvBadConverterException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * Reading the CSV File
 * Delimiter is semicolon
 * Default Quote character is double quote
 * Start reading from line 18
 */

@Component
public class ReaderCsvFileService {
    private final Charset CHARSET_WINDOWS_1250 = Charset.forName("windows-1250");
    private final char SEPARATOR = ';';
    private final int SKIP_LINES = 18;

    public List<CsvDto> builderBeanList(File file) {

        try (
                Reader reader = Files.newBufferedReader(
                        file.toPath(),
                        CHARSET_WINDOWS_1250)
        ) {
            HeaderColumnNameMappingStrategy<CsvDto> mappingStrategy = new HeaderColumnNameMappingStrategy<CsvDto>();
            mappingStrategy.setType(CsvDto.class);
            CsvToBean<CsvDto> csvToBean = new CsvToBeanBuilder<CsvDto>(reader)
                    .withType(CsvDto.class)
                    .withMappingStrategy(mappingStrategy)
                    .withSkipLines(SKIP_LINES)
                    .withSeparator(SEPARATOR)
                    .withVerifyReader(false)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            csvToBean.setThrowExceptions(false);

            return csvToBean.parse();
        } catch (IOException | CsvBadConverterException | IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
