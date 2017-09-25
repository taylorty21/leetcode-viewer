/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Iterative
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> sumStack = new Stack();
        stack.push(root);
        sumStack.add(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int tmp = sumStack.pop();
            if (node.right == null && node.left == null && tmp == sum) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(tmp + node.left.val);
            }
            if (node.right != null) {
                sumStack.push(tmp + node.right.val);
                stack.push(node.right);
            }
        }
        return false;
    }
    
    // Recursive
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}