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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> path = new Stack<>();
        stack.add(root);
        path.push("");
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            String tmpPath = path.pop();
            if (node.left == null && node.right == null) {
                res.add(tmpPath + node.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                path.push(tmpPath + node.val + "->");
            } 
            if (node.right != null) {
                stack.push(node.right);
                path.push(tmpPath + node.val + "->");
            }
            
        }
        return res;
    }
    
    public void help(List<String> list, TreeNode node, String s) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            list.add(s + node.val);
            return;
        }
        help(list, node.left, s + node.val + "->");
        help(list, node.right, s + node.val + "->");
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<String>();
        help(res, root, "");
        return res;
    }
    
    public void help2(List<String> list, TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		int len = sb.length();
		sb.append(node.val);
		if (node.left == null && node.right == null) {				
			list.add(sb.toString());
			sb.setLength(len);
			return;
		}
		sb.append("->");
		help2(list, node.left, sb);
		help2(list, node.right, sb);
		sb.setLength(len);
	}

	public List<String> binaryTreePaths3(TreeNode root) {
		List<String> res = new ArrayList<String>();
		help2(res, root, new StringBuilder());
		return res;
	}
}