package BinaryTree;
/**
 * Definition for a binary tree node.
 */
public class LCA {
    int val;
    TreeNode left;
    TreeNode right;

    LCA(int x) {
        this.val = x;
    }
}

class Solution {

    /**
     * Finds the Lowest Common Ancestor (LCA) of two given nodes in a binary tree.
     *
     * @param root the root of the binary tree
     * @param p    first node
     * @param q    second node
     * @return the lowest common ancestor of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case:
        // If root is null or matches either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If p and q are found in different subtrees, current root is LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null subtree result
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}