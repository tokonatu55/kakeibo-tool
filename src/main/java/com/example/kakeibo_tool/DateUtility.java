package com.example.kakeibo_tool;

import java.util.Calendar;
import java.util.Date;

/**
 * 日付ユーティリティ
 * @author TORI
 */
public class DateUtility {
    /**
     * その月の最初の日を返す
     * @param targetDate 対象の日付
     * @return 月の最初の日
     */
    public static Date createStartDateOfMonth(Date targetDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);

        // 月初（例: 2025-07-01 00:00:00）
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * その月の最後の日を返す
     * @param targetDate 対象の日付
     * @return 月の最後の日
     */
    public static Date createEndDateOfMonth(Date targetDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);

        // 月初の日付にする（例: 2025-07-01 00:00:00）
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 翌月初（例: 2025-07-31 23:59:59）→ 「未満」で月末までカバー
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }
}