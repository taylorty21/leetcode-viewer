/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    // Inorder traversal
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Add all the left nodes until reaching the most left node
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        // if right is not null, need to get to the right.left because it's the next smallest node
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) cur = cur.left;
                else break;
            }
        }
        return node.val;
    }
    
    // Solution 2
//     public BSTIterator2(TreeNode root) {
//         stack = new Stack<>();
//         // Add all the left nodes until reaching the most left node
//         pushAll(root);
//     }

//     /** @return whether we have a next smallest number */
//     public boolean hasNext2() {
//         return !stack.isEmpty();
//     }

//     /** @return the next smallest number */
//     public int next2() {
//         TreeNode node = stack.pop();
//         pushAll(node.right);
//         return node.val;
//     }
    
//     private void pushAll(TreeNode node) {
//         while (node != null) {
//             stack.push(node);
//             node = node.left;
//         }
//     }
    
    // Solution 3 Similar to how we write Inorder traversal
//     Stack<TreeNode> stack =  null ;            
//     TreeNode current = null ;

//     public BSTIterator(TreeNode root) {
//           current = root;	     
//           stack = new Stack<> ();
//     }

//     /** @return whether we have a next smallest number */
//     public boolean hasNext() {		  
//           return !stack.isEmpty() || current != null;  
//     }

//         /** @return the next smallest number */
//     public int next() {
//         while (current != null) {
//             stack.push(current);
//             current = current.left ;
//         }		
//         TreeNode t = stack.pop() ;		
//         current = t.right ;		
//         return t.val ;
//     }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */