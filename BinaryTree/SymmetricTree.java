
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution to check whether a binary tree is symmetric.
 *
 * A tree is symmetric if the left subtree is a mirror
 * reflection of the right subtree.
 */
public class SymmetricTree {

    /**
     * Entry point to check tree symmetry.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * Recursively checks whether two subtrees are mirrors of each other.
     */
    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null → symmetric
        if (left == null && right == null) {
            return true;
        }

        // One node is null → not symmetric
        if (left == null || right == null) {
            return false;
        }

        // Values must match
        if (left.val != right.val) {
            return false;
        }

        // Check mirror condition:
        // left child of left ↔ right child of right
        // right child of left ↔ left child of right
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
