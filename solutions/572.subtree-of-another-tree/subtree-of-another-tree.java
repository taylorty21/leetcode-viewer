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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // if (s == null || t == null) return false;
        // if (s.val == t.val && sameTree(s, t)) return true;
        if (s == null) return false;
        if (sameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean sameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
    }
    
    // Method 2: Serialize the two tree using preorder and check if the first string contains the other string 
    // return spreorder.contains(tpreorder);
}