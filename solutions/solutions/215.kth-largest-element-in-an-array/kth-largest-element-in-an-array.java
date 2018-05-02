class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap 
        // Time: (logk * n)
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}