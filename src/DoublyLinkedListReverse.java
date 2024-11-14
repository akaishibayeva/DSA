public class DoublyLinkedListReverse {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedListReverse(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // WRITE REVERSE METHOD HERE //

    public void reverse() {

        Node current = head;
        Node tempNode = null;

        while (current != null) {

            tempNode = current.prev; //stores temporarily current.prev
            current.prev = current.next; // Swap current.prev with current.next
            current.next = tempNode; // Set current.next to previously saved node
            current = current.prev; // Move to the next node in the original sequence


        }
        tempNode = head;
        head = tail;
        tail = tempNode;
    }

    public static void main(String[] args) {
        DoublyLinkedListReverse myDoublyLinkedList = new DoublyLinkedListReverse(1);

        // Append some values to the list
        myDoublyLinkedList.append(2);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.append(5);

        // Print the list before reversing
        System.out.println("Original Doubly Linked List:");
        myDoublyLinkedList.printAll();

        // Reverse the list
        myDoublyLinkedList.reverse();

        // Print the list after reversing
        System.out.println("\nReversed Doubly Linked List:");
        myDoublyLinkedList.printAll();
    }


}

