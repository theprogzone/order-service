package com.ecommerce.order_service.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    /**
     *
     * @param date
     * @param pattern: dd/MM/yyyy, dd-MM-yyyy
     * @return 12/01/2025
     */
    public static String getDateString(LocalDate date, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(date);
    }

    public static Integer calculateDateGap(LocalDate start, LocalDate end) {
        return (int) Duration.between(end.atStartOfDay(), start.atStartOfDay()).toDays();
    }
}
