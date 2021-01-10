package CodingBat.Recursion;

public class ChangeXY {

//    Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed
//        to 'y' chars.
//
//
//            changeXY("codex") → "codey"
//    changeXY("xxhixx") → "yyhiyy"
//    changeXY("xhixhix") → "yhiyhiy"
    public String changeXY(String str) {
        char from = 'x';
        char to = 'y';
        if (str.length() < 1) {
            return "";
        }
        if (str.charAt(0) == from) {
            return to + changeXY(str.substring(1));
        }
        return str.charAt(0) + changeXY(str.substring(1));
    }

    public static void main(String[] args) {
        ChangeXY res = new ChangeXY();
        System.out.println(res.changeXY("moxdexy"));
    }
}
