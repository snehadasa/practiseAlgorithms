package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReformDate {
//    Given a date string in the form Day Month Year, where:
//
//    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
//    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
//    Year is in the range [1900, 2100].
//    Convert the date string to the format YYYY-MM-DD, where:
//
//    YYYY denotes the 4 digit year.
//    MM denotes the 2 digit month.
//    DD denotes the 2 digit day.
//
//
//    Example 1:
//
//    Input: date = "20th Oct 2052"
//    Output: "2052-10-20"
//    Example 2:
//
//    Input: date = "6th Jun 1933"
//    Output: "1933-06-06"
//    Example 3:
//
//    Input: date = "26th May 1960"
//    Output: "1960-05-26"
//
//
//    Constraints:
//
//    The given dates are guaranteed to be valid, so no error handling is necessary.

    public String reformatDate(String date) {
        String day = "";
        String month = "";
        String finalDate = "";

        String givenYear = date.substring(date.length() - 4);

        if (date.contains("th")) {
            day = date.substring(0, date.indexOf("th"));
        }
        else if (date.contains("st")) {
            day = date.substring(0, date.indexOf("st"));
        }
        else if (date.contains("nd")) {
            day = date.substring(0, date.indexOf("nd"));
        }
        else if (date.contains("rd")) {
            day = date.substring(0, date.indexOf("rd"));
        }

        int checkDay = Integer.valueOf(day);
        if (checkDay < 10) {
            day = "0" + day;
        }

        Map<String, String> monthMap = new HashMap<>();

        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");


        String givenMonth = date.substring(date.length()-8, date.length()-5);
        //for (int i = 3; i < date.length(); i++) {
            //String givenMonth = date.substring(i-3, i);
            if (monthMap.containsKey(givenMonth)) {
                month = monthMap.get(givenMonth);
            }
        //}

        finalDate = givenYear + "-" + month + "-" + day;

        return finalDate;
    }

    public static void main(String[] args) {
        String date = "6th Jul 1933";
        ReformDate res = new ReformDate();
        System.out.println(res.reformatDate(date));
    }
}
