
/**
 * Binary Tree Pruning
 * 
 * Problem:
 * Remove every subtree that does NOT contain a node with value 1.
 *
 * This file contains:
 * 1. Brute Force approach (two-pass DFS)
 * 2. Optimized approach (single-pass DFS)
 */

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

public class BinaryTreePruning {

    /* =====================================================
     * 1. BRUTE FORCE APPROACH
     * =====================================================
     * Idea:
     * - First check whether a subtree contains at least one '1'
     * - If it does not, prune it
     * 
     * This results in repeated subtree checks.
     */

    public TreeNode pruneTreeBruteForce(TreeNode root) {
        if (root == null) {
            return null;
        }

        // If this subtree does not contain 1, prune it
        if (!containsOne(root)) {
            return null;
        }

        // Otherwise, recursively prune children
        root.left = pruneTreeBruteForce(root.left);
        root.right = pruneTreeBruteForce(root.right);

        return root;
    }

    /**
     * Helper method to check if a subtree contains a node with value 1
     */
    private boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.val == 1) {
            return true;
        }

        return containsOne(node.left) || containsOne(node.right);
    }

    /* =====================================================
     * 2. OPTIMIZED APPROACH (POSTORDER DFS)
     * =====================================================
     * Idea:
     * - Traverse the tree in postorder
     * - Prune children first
     * - If current node becomes a leaf with value 0 → remove it
     *
     * This solves the problem in ONE traversal.
     */

    public TreeNode pruneTreeOptimized(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively prune left and right subtrees
        root.left = pruneTreeOptimized(root.left);
        root.right = pruneTreeOptimized(root.right);

        // If current node is a leaf and value is 0, prune it
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }
}