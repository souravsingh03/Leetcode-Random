package BinaryTree;
/**
 * LeetCode 1339 - Maximum Product of Splitted Binary Tree
 *
 * Approach:
 * 1. First DFS calculates the total sum of the tree.
 * 2. Second DFS computes subtree sums and updates the maximum product
 *    by considering a split at every node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
 */
class Solution {

    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum of the tree
        totalSum = calculateTotalSum(root);

        // Step 2: compute maximum product
        computeSubtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    // DFS to calculate total sum of all nodes
    private long calculateTotalSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val
                + calculateTotalSum(node.left)
                + calculateTotalSum(node.right);
    }

    // DFS to calculate subtree sums and update max product
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subTreeSum = node.val + leftSum + rightSum;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
