package LeetCode.Easy;

public class Interpret {
//    You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or
//    "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as
//    the string "al". The interpreted strings are then concatenated in the original order.
//
//    Given the string command, return the Goal Parser's interpretation of command.
//
//
//
//    Example 1:
//
//    Input: command = "G()(al)"
//    Output: "Goal"
//    Explanation: The Goal Parser interprets the command as follows:
//            G -> G
//            () -> o
//            (al) -> al
//    The final concatenated result is "Goal".
//    Example 2:
//
//    Input: command = "G()()()()(al)"
//    Output: "Gooooal"
//    Example 3:
//
//    Input: command = "(al)G(al)()()G"
//    Output: "alGalooG"
//
//
//    Constraints:
//
//            1 <= command.length <= 100
//    command consists of "G", "()", and/or "(al)" in some order.

    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static void main(String[] args) {
        String n1 = "G()(al)";
        String n2 = "(al)G(al)()()G";
        String n3 = "G()()()()(al)";
        Interpret res = new Interpret();
        System.out.println(res.interpret(n1));
        System.out.println(res.interpret(n2));
        System.out.println(res.interpret(n3));
    }
}
