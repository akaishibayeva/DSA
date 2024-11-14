package stack;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    // WRITE PUSH METHOD HERE //

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.remove(stackList.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Create a stack of Integer type
        Stack<Integer> integerStack = new Stack<>();

        // Test if stack is empty
        System.out.println("Is stack empty? " + integerStack.isEmpty()); // true

        // Push elements onto the stack
        integerStack.push(5);
        integerStack.push(10);
        integerStack.push(15);

        // Print stack elements
        System.out.println("Stack elements:");
        integerStack.printStack(); // Should print 15, 10, 5 (top to bottom)

        // Peek the top element
        System.out.println("Top element: " + integerStack.peek()); // Should print 15

        // Check the size of the stack
        System.out.println("Stack size: " + integerStack.size()); // Should print 3

        // Pop an element from the stack
        System.out.println("Popped element: " + integerStack.pop()); // Should print 15

        // Print stack elements after pop
        System.out.println("Stack elements after pop:");
        integerStack.printStack(); // Should print 10, 5 (top to bottom)

        // Check the size of the stack
        System.out.println("Stack size: " + integerStack.size()); // Should print 2

        // Test if stack is empty
        System.out.println("Is stack empty? " + integerStack.isEmpty()); // false
    }

}