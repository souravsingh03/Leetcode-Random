package BinaryTree;
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
 * LeetCode 124: Binary Tree Maximum Path Sum
 *
 * Approach:
 * - Use DFS to compute the maximum "gain" from each node.
 * - At every node, consider the path passing through it
 *   (left + node + right) to update the global maximum.
 * - Return only one side (max of left/right) to the parent.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is tree height (recursion stack)
 */
class Solution {

    // Stores the maximum path sum found anywhere in the tree
    private static int maxSum;

    /**
     * Returns the maximum sum of a path starting from this node
     * and extending upwards to its parent.
     */
    private static int maxGain(TreeNode root) {
        if (root == null) return 0;

        // Ignore negative contributions from subtrees
        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));

        // Path passing through current node
        int currentPathSum = root.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain that can be extended to parent
        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
}
