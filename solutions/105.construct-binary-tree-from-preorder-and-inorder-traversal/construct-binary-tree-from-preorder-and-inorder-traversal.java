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
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);  
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = 0;
        // Find the root in inorder
        for (int i = is; i <= ie; i++){
            if (inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        root.left = build(preorder, inorder, ps + 1, ps + pos - is, is, pos - 1);
        //root.right = build(preorder, inorder, pe - ie + pos + 1, pe, pos + 1, ie);
        root.right = build(preorder, inorder, ps + pos - is + 1, pe, pos + 1, ie);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] { 0 }; 
        int[] inIndex = new int[] { 0 }; 
        return helperII(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE); 
    } 
 
    private TreeNode helperII(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target) { 
        // Traversing and construct the binary tree using preOrder and inOrder, 
        // the preOrder is [root][left subtree][right subtree] 
        // from the preOrder, we know the root of the binary tree, 
        // the inOrder is [left subtree][root][right subtree] 
        // when we know the root, we actually know the boundary of 
        // the left/right subtree. 
        // The "target" is actually the root, and we are using inOrder 
        // to identify the boundary of left subtree. 
        if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
            return null; 
        } 
        TreeNode root = new TreeNode(pre[preIndex[0]]); 
        // preOrder, advance the index by 1 since we already finish the root. 
        preIndex[0]++; 
        root.left = helperII(pre, in, preIndex, inIndex, root.val); 
        // inOrder, after finish the left subtree, we can advance the index by 1. 
        inIndex[0]++; 
        root.right = helperII(pre, in, preIndex, inIndex, target); 
        return root; 
    }
}