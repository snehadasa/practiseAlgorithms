package LeetCode.Easy;

public class DaysBetweenDates {
//    Write a program to count the number of days between two dates.
//
//    The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
//
//
//
//    Example 1:
//
//    Input: date1 = "2019-06-29", date2 = "2019-06-30"
//    Output: 1
//    Example 2:
//
//    Input: date1 = "2020-01-15", date2 = "2019-12-31"
//    Output: 15
//
//
//    Constraints:
//
//    The given dates are valid dates between the years 1971 and 2100.

    public boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return (year % 400 == 0);
        }
        return (year % 4 == 0);
    }
    public int totalNumberOfDays(String date) {
        int[] numOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalNumbers = 0;

        String yearOfStr = date.substring(0, 4);
        String monthOfStr = date.substring(5, 7);
        String dayOfStr = date.substring(date.length()-2);

        int year = Integer.valueOf(yearOfStr);
        int month = Integer.valueOf(monthOfStr);
        int day = Integer.valueOf(dayOfStr);

        for (int i = 0; i < month - 1; i++) {
            totalNumbers += numOfDays[i];
        }

        totalNumbers += day;

        if (isLeapYear(year) && month >= 3) {
            totalNumbers++;
        }
        return totalNumbers;
    }
    public int daysBetweenDates(String date1, String date2) {
        int firstDate = totalNumberOfDays(date1);
        int secondDate = totalNumberOfDays(date2);

        int diff = firstDate - secondDate;
        return diff;
    }

    public static void main(String[] args) {
        String date1 = "2020-01-15";
        String date2 = "2019-12-31";
        DaysBetweenDates res = new DaysBetweenDates();
        System.out.println(res.daysBetweenDates(date1, date2));
    }
}
