package stack;

public class ParenthBalancedStack {

    // WRITE THE ISBALANCEDPARENTHESES METHOD HERE //
    /*
    The method isBalancedParentheses takes a string as input and iterates through each character.
    If it encounters an open parenthesis '(', it pushes it onto the stack.
    If it encounters a close parenthesis ')', it checks if the stack is empty:
    If the stack is empty, it means there's no matching open parenthesis, so the method returns false.
    Otherwise, it pops the stack, removing the matching open parenthesis.
    After processing all characters, if the stack is empty, it means all open parentheses have been matched,
    and the string is balanced, so the method returns true. Otherwise, it returns false.
     */

    public static boolean isBalancedParentheses(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();

    }



    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }

}
