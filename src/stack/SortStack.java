package stack;

public class SortStack {

    // WRITE THE SORTSTACK METHOD HERE //
    public static void sortStack (Stack<Integer> input) {
        Stack<Integer> newStack = new Stack<>();

        while (!input.isEmpty()) {
            int temp = input.pop();

            while (!newStack.isEmpty() && newStack.peek() > temp) {
                input.push(newStack.pop());
            }
            newStack.push(temp);
        }
        while (!newStack.isEmpty()) {
            input.push(newStack.pop());
        }


    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

}


