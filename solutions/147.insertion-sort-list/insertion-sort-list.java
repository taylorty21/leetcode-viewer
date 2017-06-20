/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) { return null; }
        ListNode dummy = new ListNode(Integer.MIN_VALUE); 
        dummy.next = head; 
        ListNode cur = head, pre = dummy; 
        while (cur != null) {
            // no need to swap if it is in ascending order
            if (cur.val >= pre.val) { 
                pre = cur; 
                cur = cur.next; 
                continue; 
            }
            
            // start from dummy to look for the place to insert
            ListNode start = dummy; 
            while (start.next.val < cur.val) {
                start = start.next; 
            }
            
            ListNode next = cur.next; //the next node will be inserted
            // move cur to start and start.next
            cur.next = start.next; 
            start.next = cur; 
            // For next iteration
            pre.next = next; 
            cur = next; 
        }
        
        return dummy.next; 
    }
}