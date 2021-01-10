package CodingBat;

public class StartOz {

    public static void main(String[] args) {
        String str1 = "ozymandias";
        String str2 = "odsff";
        String str3 = "ezymandias";

        StartOz res = new StartOz();
        System.out.println(res.startOz(str1));
        System.out.println(res.startOz(str2));
        System.out.println(res.startOz(str3));
    }

//    Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
//
//
//    startOz("ozymandias") → "oz"
//    startOz("bzoo") → "z"
//    startOz("oxx") → "o"
    public String startOz(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() >= 2 && str.charAt(0) == 'o' && str.charAt(1) == 'z') {
            return "oz";
        }
        if (str.charAt(0) == 'o') {
            return "o";
        }
        if (str.charAt(1) == 'z') {
            return "z";
        }

        return "";

//        String result = "";
//
//        if (str.length() >= 1 && str.charAt(0)=='o') {
//            result = result + str.charAt(0);
//        }
//
//        if (str.length() >= 2 && str.charAt(1)=='z') {
//            result = result + str.charAt(1);
//        }
//
//        return result;
    }
}
