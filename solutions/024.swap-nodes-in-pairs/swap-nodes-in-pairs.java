/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            //       1    ->     2  ->   3   ->4
            // curr, first, second
            //       2    ->     1  ->   3
            first.next = second.next; // 1.next = 2.next = 3
            current.next = second;    // put 2 to the front
            current.next.next = first; // curr.next.next = 1
            
            current = current.next.next; // move forward
        }
        return dummy.next;
    }
    
    public ListNode swapPairsRec(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairsRec(head.next.next);
        n.next = head;
        return n;
    }
}