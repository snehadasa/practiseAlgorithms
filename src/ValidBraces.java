import java.util.Stack;

public class ValidBraces {

    public boolean validBraces(String str) {
        Stack<Character> braces = new Stack<>();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];

            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                braces.push(currentChar);
            }
            if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                if (braces.empty()) {
                    return false;
                }
                Character toCompare = 1;
                char pop = braces.pop();
                switch (pop) {
                    case '[':
                        toCompare = '}';
                        break;
                    case '{':
                        toCompare = '}';
                        break;
                    case '(':
                        toCompare = ')';
                        break;
                    default:
                        break;
                }
                if (toCompare != currentChar) {
                    return false;
                }
            }
        }
        return braces.empty();

    }
}
