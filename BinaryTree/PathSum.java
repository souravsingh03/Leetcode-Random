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

class Solution {

    /**
     * Helper DFS method to check if a root-to-leaf path
     * exists with the given target sum.
     *
     * @param root   current node
     * @param target target sum to match
     * @param sum    sum accumulated so far
     * @return true if a valid path exists, otherwise false
     */
    private static boolean hasPath(TreeNode root, int target, int sum) {
        // Base case: empty node
        if (root == null) {
            return false;
        }

        // Add current node value to path sum
        sum += root.val;

        // Check if leaf node and sum matches target
        if (root.left == null && root.right == null) {
            return sum == target;
        }

        // Recur for left and right subtrees
        return hasPath(root.left, target, sum)
                || hasPath(root.right, target, sum);
    }

    /**
     * Main function called by LeetCode.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }
}
