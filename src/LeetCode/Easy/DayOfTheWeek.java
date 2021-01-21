package LeetCode.Easy;

import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DayOfTheWeek {
//    Given a date, return the corresponding day of the week for that date.
//
//    The input is given as three integers representing the day, month and year respectively.
//
//    Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
//
//
//
//    Example 1:
//
//    Input: day = 31, month = 8, year = 2019
//    Output: "Saturday"
//    Example 2:
//
//    Input: day = 18, month = 7, year = 1999
//    Output: "Sunday"
//    Example 3:
//
//    Input: day = 15, month = 8, year = 1993
//    Output: "Sunday"
//
//
//    Constraints:
//
//    The given dates are valid dates between the years 1971 and 2100.

    public String dayOfTheWeek1(int day, int month, int year) {
        Map<Integer, String> getDay = new HashMap<>();
        getDay.put(1, "Sunday");
        getDay.put(2, "Monday");
        getDay.put(3, "Tuesday");
        getDay.put(4, "Wednesday");
        getDay.put(5, "Thursday");
        getDay.put(6, "Friday");
        getDay.put(7, "Saturday");

        Calendar c = Calendar.getInstance();
        c.set(day, month, year);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return getDay.get(dayOfWeek);
    }
    public String dayOfTheWeek(int day, int month, int year) {
        return java.time.LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
    }

        public static void main(String[] args) {
        DayOfTheWeek res = new DayOfTheWeek();
        int day = 15, month = 8, year = 1999;
        System.out.println(res.dayOfTheWeek(day,month,year));
    }
}
