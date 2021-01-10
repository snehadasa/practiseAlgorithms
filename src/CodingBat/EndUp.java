package CodingBat;

public class EndUp {
    public String endUp(String str) {
        if (str.length() <= 3) {
            return str.toUpperCase();
        }
        return str.substring(0, (str.length() - 3)) + str.substring(str.length() - 3).toUpperCase();
    }

    public static void main(String[] args) {
        String str1 = "hi";
        String str2 = "hello";
        String str3 = "bangalore";
        EndUp res = new EndUp();
        System.out.println(res.endUp(str1));
        System.out.println(res.endUp(str2));
        System.out.println(res.endUp(str3));
    }
}
