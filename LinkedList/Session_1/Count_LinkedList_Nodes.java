package LinkedList.Session_1;

public class Count_LinkedList_Nodes {
    // Function to count nodes of a linked list.
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public static int getCount(Node head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}
