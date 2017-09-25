/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // BFS + HashMap
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> horizontalDistanceQueue = new LinkedList<>();
        horizontalDistanceQueue.offer(0);
        queue.offer(root);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int horizontalDistance = horizontalDistanceQueue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                horizontalDistanceQueue.offer(horizontalDistance - 1);
                min = Math.min(min, horizontalDistance - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                horizontalDistanceQueue.offer(horizontalDistance + 1);
                max = Math.max(max, horizontalDistance + 1);
            }
            if (!map.containsKey(horizontalDistance)) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(horizontalDistance, list);
            } else {
                List<Integer> list = map.get(horizontalDistance);
                list.add(node.val);
                map.put(horizontalDistance, list);
            }
                
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}