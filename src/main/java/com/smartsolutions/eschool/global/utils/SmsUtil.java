package com.smartsolutions.eschool.global.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SmsUtil {
    public static List<String> getAcademicMonths(LocalDate startDate, Long totalMonths) {
        List<String> months = new ArrayList<>();
        if (startDate == null || totalMonths <= 0) {
            return months;
        }

        for (int i = 0; i < totalMonths; i++) {
            // Add i months to the start date
            LocalDate date = startDate.plusMonths(i);
            // Get month name in full form (e.g., "January")
            String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            months.add(monthName);
        }
        return months;
    }
}
