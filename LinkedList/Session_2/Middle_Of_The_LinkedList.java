package LinkedList.Session_2;

public class Middle_Of_The_LinkedList {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
