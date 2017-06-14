public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                // Remove the head of the queue
                pq.poll();
            }
        }
        return pq.peek();
    }
}