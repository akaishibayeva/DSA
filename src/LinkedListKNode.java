public class LinkedListKNode {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListKNode (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // WRITE FINDKTHFROMEND METHOD HERE //

    public Node findKthFromEnd (int k) {

        if (k <= 0) return null;

        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null) return null;

            first = first.next;
        }

        while(first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void main(String[] args) {
        LinkedListKNode myList = new LinkedListKNode(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        Node result = myList.findKthFromEnd(2); // Output: Node with value 4
        if (result != null) {
            System.out.println("K-th node from the end: " + result.value);
        } else {
            System.out.println("K-th node from the end is null");
        }

        result = myList.findKthFromEnd(5); // Output: Node with value 1
        if (result != null) {
            System.out.println("K-th node from the end: " + result.value);
        } else {
            System.out.println("K-th node from the end is null");
        }

        result = myList.findKthFromEnd(6); // Output: null
        if (result != null) {
            System.out.println("K-th node from the end: " + result.value);
        } else {
            System.out.println("K-th node from the end is null");
        }
    }

}

