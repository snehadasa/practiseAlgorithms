package CodingBat.Recursion;

public class ParenBit {
/*
    Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the
    parenthesis and their contents, so "xyz(abc)123" yields "(abc)".


    parenBit("xyz(abc)123") → "(abc)"
    parenBit("x(hello)") → "(hello)"
    parenBit("(xy)1") → "(xy)"

    TEST-CASES

    parenBit("xyz(abc)123") → "(abc)"	"(abc)"	OK
    parenBit("x(hello)") → "(hello)"	"(hello)"	OK
    parenBit("(xy)1") → "(xy)"	"(xy)"	OK
    parenBit("not really (possible)") → "(possible)"	"(possible)"	OK
    parenBit("(abc)") → "(abc)"	"(abc)"	OK
    parenBit("(abc)xyz") → "(abc)"	"(abc)"	OK
    parenBit("(abc)x") → "(abc)"	"(abc)"	OK
    parenBit("(x)") → "(x)"	"(x)"	OK
    parenBit("()") → "()"	"()"	OK
    parenBit("res (ipsa) loquitor") → "(ipsa)"	"(ipsa)"	OK
    parenBit("hello(not really)there") → "(not really)"	"(not really)"	OK
    parenBit("ab(ab)ab") → "(ab)"	"(ab)"	OK
 */

    public String parenBit(String str) {
      if (str.length() < 1) {
          return "";
      }
      if (str.charAt(0) != '(') {
          return parenBit(str.substring(1));
      }
      if (str.charAt(str.length() - 1) != ')') {
          return parenBit(str.substring(0, str.length() - 1));
      }
      return str;
    }

    public static void main(String[] args) {
        ParenBit res = new ParenBit();

        System.out.println(res.parenBit("xyz(abc)123"));
    }
}
