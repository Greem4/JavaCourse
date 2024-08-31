package edu.greem4.http.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@UtilityClass
public class LocalDateFormater {

    public static final String PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public LocalDate format(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public boolean isValid(String date) {
//        try {
//            return Optional.ofNullable(date)
//                    .map(LocalDateFormater::format)
//                    .isPresent();
//        } catch (DateTimeParseException e) {
//            return false;
//        }
        try {
            format(date);
            return true;
        }catch (DateTimeParseException e) {
            return false;
        }
    }
}
