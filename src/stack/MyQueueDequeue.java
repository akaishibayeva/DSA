package stack;

public class MyQueueDequeue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueueDequeue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // WRITE THE DEQUEUE METHOD HERE //
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return stack1.pop();
        }
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {

        // Create a new queue
        MyQueueDequeue q = new MyQueueDequeue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the queue
        System.out.println("Front of the queue: " + q.peek()); //1

        // Dequeue some values
        System.out.println("Dequeued value: " + q.dequeue()); //1
        System.out.println("Dequeued value: " + q.dequeue()); //2

        // Enqueue another value
        q.enqueue(4);

        // Output the front of the queue again
        System.out.println("Front of the queue: " + q.peek());

        // Dequeue all remaining values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty());

        // Dequeue from an empty queue and check if it returns null
        System.out.println("Dequeued value from empty queue: " + q.dequeue());


        /*
            EXPECTED OUTPUT:
            ----------------
            Front of the queue: 1
            Dequeued value: 1
            Dequeued value: 2
            Front of the queue: 3
            Dequeued value: 3
            Dequeued value: 4
            Is the queue empty? true
            Dequeued value from empty queue: null
        */

    }

}
