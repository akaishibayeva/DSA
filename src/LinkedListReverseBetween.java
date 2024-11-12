public class LinkedListReverseBetween {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListReverseBetween(int value) {
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
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
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
        }
        length++;
    }

    // WRITE THE REVERSEBETWEEN METHOD HERE //

    public void reverseBetween(int m, int n) {

        if (head == null) return;

        //Create a dummy node with value 0
        Node dummy = new Node(0);
        //Set the next of the dummy node to the head of the list
        dummy.next = head;
        //Initialize prev pointer to the dummy node
        Node preStart = dummy;

        /*
        Loop from 0 to m-1
        Move prev pointer one step ahead in the list
         */
        for (int i = 0; i < m; i++) {
            preStart = preStart.next;
        }

        //Initialize current pointer to the next node of prev pointer
        // `current` will point to the node at `startIndex`
        Node current = preStart.next;

        /*
        Loop from 0 to n-m
        Set temp pointer to the next node of current pointer
        Update the next of current pointer to the next of temp pointer
        Update the next of temp pointer to the next of prev pointer
        Update the next of prev pointer to the temp pointer
         */

        // Reverse the sublist from `startIndex` to `endIndex`
        for (int i = 0; i < n - m; i++) {
            Node next = current.next;
            current.next = next.next;
            next.next = preStart.next;
            preStart.next = next;
        }
        head = dummy.next;

    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 2, 3, 4, 5
        LinkedListReverseBetween list = new LinkedListReverseBetween(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse nodes between index 1 and 3
        list.reverseBetween(1, 3);

        // Print the modified list
        System.out.println("Modified List after reversing between index 1 and 3:");
        list.printList();
    }
}

    /*
    Expected Output:
    Original List:
    1 -> 2 -> 3 -> 4 -> 5 -> null
    Modified List after reversing between index 1 and 3:
    1 -> 4 -> 3 -> 2 -> 5 -> null
    */

