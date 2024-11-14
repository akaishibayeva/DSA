public class DoublyLinkedListPalindrome {

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

    public DoublyLinkedListPalindrome(int value) {
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

    // WRITE ISPALINDROME METHOD HERE //

    /*
    If the length of the list is less than or equal to 1, then the list is a palindrome by definition, so the method returns True.

The method initializes two pointers, forward and backward, that point to the head and tail of the list, respectively.
The method then iterates over half of the list, comparing the values of the nodes at each end of the list to see if they are the same.

If the values of the nodes do not match, the method returns false, indicating that the list is not a palindrome.
If all of the values match, the method returns true, indicating that the list is a palindrome.
     */

    public boolean isPalindrome() {
        if (length <= 1) return true; //this is palindrome

        Node forward = head;
        Node backward = tail;

        for (int i = 0; i < length/2; i++) {
            if (forward.value != backward.value) {
                return false;
            }

            forward = forward.next;
            backward = backward.prev;
        }

        return true;
    }

}

