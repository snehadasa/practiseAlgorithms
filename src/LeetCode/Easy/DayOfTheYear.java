package LeetCode.Easy;

public class DayOfTheYear {
//    Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
//
//
//
//    Example 1:
//
//    Input: date = "2019-01-09"
//    Output: 9
//    Explanation: Given date is the 9th day of the year in 2019.
//    Example 2:
//
//    Input: date = "2019-02-10"
//    Output: 41
//    Example 3:
//
//    Input: date = "2003-03-01"
//    Output: 60
//    Example 4:
//
//    Input: date = "2004-03-01"
//    Output: 61
//
//
//    Constraints:
//
//    date.length == 10
//    date[4] == date[7] == '-', and all other date[i]'s are digits
//    date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.

    public boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return (year % 400 == 0);
        }
        return (year % 4 == 0);
    }

    public int dayOfYear(String date) {
        int[] numOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalNumbers = 0;

        String yearString = date.substring(0, 4);
        String monthString = date.substring(5, 7);
        String dayString = date.substring(date.length()-2);

        int year = Integer.valueOf(yearString);
        int month = Integer.valueOf(monthString);
        int day = Integer.valueOf(dayString);

        for (int i = 0; i < month-1; i++) {
            totalNumbers += numOfDays[i];
        }
        totalNumbers += day;

        if (isLeapYear(year) && month >= 3) {
            totalNumbers++;
        }

        return totalNumbers;
    }
    public static void main(String[] args) {
        String date = "2000-03-10";
        DayOfTheYear res = new DayOfTheYear();
        System.out.println(res.dayOfYear(date));
    }
}
