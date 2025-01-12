package com.ecommerce.order_service.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateUtilTest {

    @Test
    public void getDateStringTest() {
        LocalDate localDate = LocalDate.now();
        String result = DateUtil.getDateString(localDate, "dd/MM/yyyy");
        Assertions.assertEquals("12/01/2025", result);
    }

    @Test
    public void getDateStringTest_NullPattern() {
        LocalDate localDate = LocalDate.now();
        String result = DateUtil.getDateString(localDate, null);
        Assertions.assertEquals("", result);
    }

    @Test
    public void getDateStringTest_EmptyPattern() {
        LocalDate localDate = LocalDate.now();
        String result = DateUtil.getDateString(localDate, "");
        Assertions.assertEquals("", result);
    }

    @Test
    public void calculateDateGapTest() {
        LocalDate date1 = LocalDate.of(2025, 1, 12);
        LocalDate date2 = LocalDate.of(2025, 1, 1);
        Integer result = DateUtil.calculateDateGap(date1, date2);
        Assertions.assertEquals(11, result);
    }
}
