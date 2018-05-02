/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Two-pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = dummy;
        // if (n != length && n < length) {
        //     for (int i = 0; i < length - n; i++) {
        //         curr = curr.next;
        //     }
        // }
        // curr.next = curr.next.next;
        length -= n;
        while (length > 0) {
            length--;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
    
    // One-pass solution
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}