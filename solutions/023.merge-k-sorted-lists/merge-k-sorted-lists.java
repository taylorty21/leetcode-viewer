/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Method 1: Merge two sorted lists each time. Like merge sort
    // Method 2: Binary Reduction
    // Time: nlogk where k is the number of lists and n is total number of nodes.
    // merge takes O(n) time and partition takes O(logk) time
    public static ListNode mergeKLists2(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    // Method 3: k pointers, use min heap
    // If there are n*k elements
    // Time: O(k*logk*n)
    // Space: O(k)
    // you can think about the complexity on each node and expand. For each node, the complexity is O(logk), which is the complexity for adding to the PQ, and there are k*n that many of nodes, which gives us O(knlogk).
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, 
         new Comparator<ListNode>() {
             @Override
             public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) return 0;
                return n1.val < n2.val? -1 : 1;
             }
         });
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode listNode: lists) {
            if (listNode != null) minHeap.offer(listNode);
        }
        
        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            if (curr.next.next != null) {
                minHeap.offer(curr.next.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}