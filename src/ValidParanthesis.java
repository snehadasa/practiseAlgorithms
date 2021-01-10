import java.util.Stack;

public class ValidParanthesis {
    public boolean isValidString(String str) {
        Stack<Character> braces = new Stack<>();
        char[] charArray = str.toCharArray();
        for (int i = 0 ; i < str.length(); i++) {
            char currentChar = charArray[i];
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                braces.push(currentChar);
            }
            if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (braces.empty()) {
                    return  false;
                }
                Character pop = braces.pop();
                char toCompare = '1';
                switch (pop) {
                    case '[':
                        toCompare = ']';
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

    public static void main(String []args) {
        ValidParanthesis paranthesis = new ValidParanthesis();
//        System.out.println(paranthesis.isValidString("[adf{asdf)]"));
//        System.out.println(paranthesis.isValidString("[adf{asdf}]"));
        System.out.println(paranthesis.isValidString("[{}]"));
//        System.out.println(paranthesis.isValidString("[adf{asdf}"));

    }

}
