/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Time: O(n)
 // Space: O(n)
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
  
    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null || node1.val != node2.val) {
            // 每次写这种判断语句 一定要先判断node是否为null
            return false;
        }
        return isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);
    }
}