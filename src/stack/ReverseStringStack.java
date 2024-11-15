package stack;

public class ReverseStringStack {

    // WRITE THE REVERSESTRING METHOD HERE //

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);
        }
        String result = charStackToString(stack);

        return result;

    }

    //Helper method that converts characters stored in Stack to String
    public static String charStackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }



    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
