package LinkedList.Session_4;

public class Detect_Loop_In_LinkedList {
    // Function to check if the linked list has a loop.
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
