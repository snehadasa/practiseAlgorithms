import java.util.Stack;

public class ValidBraces {

    public boolean validBraces(String str) {
       char[] charArr = str.toCharArray();
       Stack<Character> braces = new Stack();

       for (int i = 0; i < charArr.length; i++) {
           if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') {
               braces.push(charArr[i]);
           }

           if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']') {
               if (braces.empty()) {
                   return false;
               }

               Character toCompare = 1;
               Character pop = braces.pop();
               switch (pop) {
                   case '(':
                       toCompare = ')';
                       break;
                       case '{':
                       toCompare = '}';
                       break;
                       case '[':
                       toCompare = ']';
                       break;
                   default:break;
               }
               if (toCompare != charArr[i]) {
                   return false;
               }
           }
       }
       return braces.empty();
    }
}
