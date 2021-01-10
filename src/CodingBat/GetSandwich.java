package CodingBat;

public class GetSandwich {

//    A sandwich is two pieces of bread with something in between. Return the string that is between the first and
//    last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
//
//
//            getSandwich("breadjambread") → "jam"
//    getSandwich("xxbreadjambreadyybread") → "jambreadyy"
//    getSandwich("xxbreadyy") → ""


    public String getSandwich(String str) {
        int firstindex = -1, lastindex = -1;
        if (str.length() < 10)
            return "";

        for (int i = 0; i <= str.length(); i++) {
            if (str.substring(i, i + 5).equals("bread")) {
                firstindex = i;
                break;
            }
        }
        for (int i = str.length() - 5; i >= firstindex + 5 && i > 0; i--) {
            if (str.substring(i, i + 5).equals("bread")) {
                lastindex = i;
                break;
            }
        }
        if (firstindex == -1 || lastindex == -1) {
            return "";
        }
        return (str.substring(firstindex + 5, lastindex));
    }

    public static void main(String[] args) {
        String str1 = "breadjambreadopdnf";
        String str2 = "xxbreadjambreadyybread";
        String str3 = "xxbreadyy";

        GetSandwich res = new GetSandwich();
        System.out.println(res.getSandwich(str1));
        System.out.println(res.getSandwich(str2));
        System.out.println(res.getSandwich(str3));
    }
}
