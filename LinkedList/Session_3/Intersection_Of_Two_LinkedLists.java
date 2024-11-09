package LinkedList.Session_3;

public class Intersection_Of_Two_LinkedLists {
    /**
     * TC: O(2 x M + 2 x N) ~ O(M + N)
     * SC: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
            if (currA == currB) {
                return currA;
            }
            if (currA == null) {
                currA = headB;
            }
            if (currB == null) {
                currB = headA;
            }
        }
        return currA;
    }
}

/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
