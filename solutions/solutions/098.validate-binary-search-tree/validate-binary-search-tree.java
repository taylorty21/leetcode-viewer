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
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    //   1
    //  / \
    // 2   3
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.right, root.val, max) && isValidBST(root.left, min, root.val);
    }
    
    TreeNode invalidNode = new TreeNode(Integer.MAX_VALUE);
    
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        return validate(root, null) != invalidNode;
    }
    
    public TreeNode validate(TreeNode node, TreeNode prev) {
        if (node == null) return prev;
        prev = validate(node.left, prev);
        if (prev != null && prev.val >= node.val) return invalidNode;
        return validate(node.right, node);
    }
}