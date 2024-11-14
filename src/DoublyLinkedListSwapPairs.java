public class DoublyLinkedListSwapPairs {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedListSwapPairs(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        length++;
    }

    // Method to swap adjacent pairs in the list
    public void swapPairs() {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, nothing to swap
            return;
        }

        Node current = head;
        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;

            // Swap the two nodes by updating pointers
            Node prev = first.prev;
            Node next = second.next;

            // Connect 'second' to 'prev' and 'next'
            if (prev != null) {
                prev.next = second;
            } else {
                // Update head if swapping the first pair
                head = second;
            }
            second.prev = prev;
            second.next = first;

            // Connect 'first' to 'second' and 'next'
            first.prev = second;
            first.next = next;
            if (next != null) {
                next.prev = first;
            }

            // Move current pointer to the next pair
            current = next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListSwapPairs dll = new DoublyLinkedListSwapPairs(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        System.out.println("Before swapping pairs:");
        dll.printList();

        dll.swapPairs();

        System.out.println("After swapping pairs:");
        dll.printList();
    }
}
