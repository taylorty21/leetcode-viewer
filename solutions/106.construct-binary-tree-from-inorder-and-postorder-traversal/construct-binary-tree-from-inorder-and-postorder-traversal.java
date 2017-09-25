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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        
    }
    
    public TreeNode build(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int pos = 0;
        // Find the root in inorder
        for (int i = is; i <= ie; i++){
            if (inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        root.left = build(inorder, postorder, is, pos - 1, ps, ps + pos - is - 1);
        root.right = build(inorder, postorder, pos + 1, ie, ps + pos - is, pe - 1);
        return root;
    }
}