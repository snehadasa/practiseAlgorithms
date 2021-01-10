package LeetCode.Easy;

public class DefangIPaddr {
//    Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//    A defanged IP address replaces every period "." with "[.]".
//
//
//
//    Example 1:
//
//    Input: address = "1.1.1.1"
//    Output: "1[.]1[.]1[.]1"
//    Example 2:
//
//    Input: address = "255.100.50.0"
//    Output: "255[.]100[.]50[.]0"

    public String defangIPaddr(String address) {
        String res = "";
        boolean flag = false;
        for (int i = 0; i <= address.length() - 2; i++) {
            if (address.charAt(i) == '.') {
                flag = true;
            }
            if (flag) {
                res = address.replace(".", "[.]");
                //res = address.substring(0, i - 1) + "[" + "." + "]" + address.substring(i + 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        DefangIPaddr res = new DefangIPaddr();
        System.out.println(res.defangIPaddr(address));
    }
}
