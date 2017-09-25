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
    // This method also works for those who are not BSTs. 
    // The idea is to use a hashtable to save the values of the nodes in the BST. Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val.
    // Time Complexity: O(n), Space Complexity: O(n).
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    
    // The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder traversal. Then, we use two pointers which begins from the start and end of the array to find if there is a sum k.
    // Time Complexity: O(n), Space Complexity: O(n).
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int l = 0, r = inorderList.size() - 1;
        while (l < r) {
            if (inorderList.get(l) + inorderList.get(r) == k) {
                return true;
            } else if (inorderList.get(l) + inorderList.get(r) < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}