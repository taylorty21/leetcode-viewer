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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String result = t.val + "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if (left.equals("") && right.equals("")) return result;
        if (left.equals("")) return result + "()" + "(" + right + ")";
        if (right.equals("")) return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
    
    public String tree2str2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    
    public void helper(StringBuilder sb,TreeNode t){
        if (t!=null){
            sb.append(t.val);
            if(t.left != null || t.right != null) {
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");
                if (t.right != null) {
                    sb.append("(");
                    helper(sb,t.right);
                    sb.append(")");
                }
            }
        }
    }
}