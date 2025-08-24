package com.example.kakeibo_tool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DateUtilityTest {
    @Test
    void 日付の2025年8月19日を渡したら2025年8月1日が返る() throws ParseException {
        String dateString = "2025/08/19 19:30:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = formatter.parse(dateString);
        Date startDate = DateUtility.createStartDateOfMonth(date);
        //System.out.println(startDate.toString());
        SimpleDateFormat afterFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //System.out.println(afterFormatter.format(startDate));
        assertEquals("2025/08/01 00:00:00", afterFormatter.format(startDate));
    }

    @Test
    void 日付の2025年8月1日を渡したら2025年8月1日が返る() throws ParseException {
        String dateString = "2025/08/01 00:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = formatter.parse(dateString);
        Date startDate = DateUtility.createStartDateOfMonth(date);
        //System.out.println(startDate.toString());
        SimpleDateFormat afterFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //System.out.println(afterFormatter.format(startDate));
        assertEquals("2025/08/01 00:00:00", afterFormatter.format(startDate));
    }
}
