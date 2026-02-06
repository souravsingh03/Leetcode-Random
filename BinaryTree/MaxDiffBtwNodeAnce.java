package BinaryTree;
/**
 * LeetCode: Maximum Difference Between Node and Ancestor
 *
 * This file contains TWO approaches:
 * 1. Brute Force (O(N^2)) – compares every ancestor with all descendants
 * 2. Optimal DFS (O(N)) – carries min and max values along the path
 *
 * Author: Sourav Singh
 */

class MaxAncestorDifference {

    /* ---------------- TreeNode Definition ---------------- */
    static class TreeNode {
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

    /* ======================================================
       APPROACH 1: BRUTE FORCE
       Time Complexity: O(N^2)
       Space Complexity: O(H)
       ====================================================== */

    private int bruteMaxDiff;

    private void compareWithDescendants(TreeNode ancestor, TreeNode node) {
        if (node == null) return;

        bruteMaxDiff = Math.max(bruteMaxDiff, Math.abs(ancestor.val - node.val));
        compareWithDescendants(ancestor, node.left);
        compareWithDescendants(ancestor, node.right);
    }

    private void bruteDFS(TreeNode root) {
        if (root == null) return;

        compareWithDescendants(root, root.left);
        compareWithDescendants(root, root.right);

        bruteDFS(root.left);
        bruteDFS(root.right);
    }

    public int maxAncestorDiffBruteForce(TreeNode root) {
        bruteMaxDiff = 0;
        bruteDFS(root);
        return bruteMaxDiff;
    }

    /* ======================================================
       APPROACH 2: OPTIMAL DFS
       Time Complexity: O(N)
       Space Complexity: O(H)
       ====================================================== */

    private int optimalDFS(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return maxVal - minVal;
        }

        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);

        int left = optimalDFS(root.left, minVal, maxVal);
        int right = optimalDFS(root.right, minVal, maxVal);

        return Math.max(left, right);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return optimalDFS(root, root.val, root.val);
    }
}
