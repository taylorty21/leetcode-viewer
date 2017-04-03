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
    // Iterative:
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            // Add left children and iterate to the left most node
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            // if the curr node is null
            curr = stack.pop();
            // Add left node to the result
            res.add(curr.val);
            // Iterate to the right subtree
            curr = curr.right;
        }
        return res;
    }
        
    // Recursive:
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     inorderTraversal(root, res);
    //     return res;
    // }
    
    // private void inorderTraversal(TreeNode root, List<Integer> res) {
    //     if (root != null) {
    //         inorderTraversal(root.left, res);
    //         res.add(root.val);
    //         inorderTraversal(root.right, res);
    //     }
    // }
    
}