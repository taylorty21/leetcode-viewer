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
    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 0);
        return res;
    }
    
    public void dfs(List<Integer> res, TreeNode root, int currDepth) {
        if (root == null) return;
        if (currDepth == res.size()) {
            res.add(root.val);
        }
        // flip the two lines to get left side view
        dfs(res, root.right, currDepth + 1);
        dfs(res, root.left, currDepth + 1);
    }
    
    // BFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // res.add(queue.peek().val); left side view
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}