package CodingBat;

public class ParrotTrouble {

//    We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23.
//    We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble.
//
//
//    parrotTrouble(true, 6) → true
//    parrotTrouble(true, 7) → false
//    parrotTrouble(false, 6) → false

    public boolean parrotTrouble(boolean talking, int hour) {
        if (talking == true && (hour < 7 || hour > 20)) {
            return true;
        } else
        if (talking == true && (hour > 7 || hour < 20)) {
            return false;
        }
        if (talking == false && (hour < 7 || hour > 20)) {
            return false;
        } else
        return false;
    }

//    public boolean parrotTrouble(boolean talking, int hour) {
//        return (talking && (hour < 7 || hour > 20));
//        // Need extra parenthesis around the || clause
//        // since && binds more tightly than ||
//        // && is like arithmetic *, || is like arithmetic +
//    }

    public static void main(String[] args) {
        boolean talking1 = true, talking2 = true, talking3 = false;
        int hour1 = 6, hour2 = 7, hour3 = 6;
        ParrotTrouble res = new ParrotTrouble();
        System.out.println(res.parrotTrouble(talking1, hour1));
        System.out.println(res.parrotTrouble(talking2, hour2));
        System.out.println(res.parrotTrouble(talking3, hour3));
    }
}
