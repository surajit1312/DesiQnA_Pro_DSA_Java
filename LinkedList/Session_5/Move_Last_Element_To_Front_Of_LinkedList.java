package LinkedList.Session_5;

public class Move_Last_Element_To_Front_Of_LinkedList {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static Node moveToFront(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node current = head;
        while (current != null && current.next != null) { // TC: O(N)
            prev = current;
            current = current.next;
        }
        // current points to last node
        prev.next = null; // setting next of last but one's next to null
        current.next = head; // setting last node's next to head
        return current;
    }
}

/*
 * Definition for singly Link List Node
 */
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
