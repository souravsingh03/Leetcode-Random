
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
 * Count Complete Tree Nodes
 * 
 * This file contains:
 * 1. Brute Force DFS solution
 * 2. Optimized solution using complete binary tree properties
 */
class Solution {

    /* ---------------- Brute Force Approach ---------------- */

    /**
     * Brute force DFS traversal
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public int countNodesBruteForce(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesBruteForce(root.left)
                 + countNodesBruteForce(root.right);
    }

    /* ---------------- Optimized Approach ---------------- */

    /**
     * Computes left height of the tree
     */
    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    /**
     * Computes right height of the tree
     */
    private int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    /**
     * Optimized solution using properties of complete binary tree
     * Time Complexity: O((log n)^2)
     * Space Complexity: O(log n)
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        // If tree is perfect, directly compute nodes
        if (lh == rh) {
            return (1 << lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
