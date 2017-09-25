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
    // Use Preorder
    private String nullString = "X";
    private String seperator = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val).append(seperator);;
            preorder(root.left, sb);
            preorder(root.right, sb);
        } else {
            sb.append(nullString).append(seperator);;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(seperator)));
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(nullString)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));