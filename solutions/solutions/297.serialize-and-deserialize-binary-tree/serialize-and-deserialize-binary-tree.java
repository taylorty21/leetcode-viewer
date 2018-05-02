/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL + " ");
            return;
        }
        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(" ");
        int[] index = new int[]{0};
        return build(array, index);
    }
    
    private TreeNode build(String[] array, int[] index) {
        if (index[0] == array.length) {
           return null; 
        }
        
        // String curr = array[index[0]++];
        String curr = array[index[0]];
        index[0]++;
        if (curr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = build(array, index);
        root.right = build(array, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));