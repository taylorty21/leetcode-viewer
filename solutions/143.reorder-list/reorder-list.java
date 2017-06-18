/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        // L0→L1→…→Ln-1→Ln
        // L0→L1→L2→null
        // L3→L4→null
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Find middle
        // Pay attention to the two lines below, slow.next must be set to null
        ListNode tmp = slow.next;
        slow.next = null;
        merge(head, reverse(tmp));
    }
    
    public void merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr.next.next = l2;
            // curr = curr.next;
            // curr.next = l2;
            l2 = l2.next;
            // curr = curr.next;
            curr = curr.next.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        l1 = dummy.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}