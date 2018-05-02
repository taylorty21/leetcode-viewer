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
    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (max < node.val) {
                    max = node.val;
                }
            }
            res.add(max);
        }
        return res;
    }
    
    // DFS
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> returnVal = new ArrayList<>();
        largestValue(root, returnVal, 0);        
        return returnVal;
    }
    
    private void largestValue(TreeNode root, List<Integer> returnVal, int depth) {
        if (root == null) {
            return;
        }
        
        if (returnVal.size() > depth) {
           returnVal.set(depth, Math.max(root.val, returnVal.get(depth)));
        } else {
            returnVal.add(root.val);
        }
        largestValue(root.left, returnVal, depth + 1);
        largestValue(root.right, returnVal, depth + 1);
    }
}