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
//     We want to compare all diameters among all subtrees.
//     Then this can be done when we DFS traverse the root.
//     We just need to record the maximum one in a variable.
//     The variable is the int max.
//     max = Math.max(max, left + right) is to compare whether the diameter of this subtree is max or not, if it is, record it.
//     And the remaining part in the maxDepth is just the normal height counting.
    
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
    
    // performance is not good because of the overlapping subproblems when calculate depth.
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        int cur = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(cur, Math.max(left, right));
    }
    
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}