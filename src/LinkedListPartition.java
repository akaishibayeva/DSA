public class LinkedListPartition {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListPartition(int value) {
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
        if (head == null) {
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

    // WRITE THE PARTITIONLIST METHOD HERE //

    public void partitionList(int x) {

        //Dummy nodes to less and greater list
        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        //Pointers to build two lists
        Node less = lessHead;
        Node greater = greaterHead;

        //Loop through original list
        Node current = head;
        while (current != null) {
            if (current.value < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        // Terminate the greater list
        greater.next = null;

        // Connect the less list with the greater list
        less.next = greaterHead.next;

        // Update the head of the original list
        head = lessHead.next;
    }

    public static void main(String[] args) {
        LinkedListPartition list = new LinkedListPartition(3);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);

        System.out.println("Original List:");
        list.printList();

        list.partitionList(5);

        System.out.println("\nPartitioned List:");
        list.printList();
    }

}

