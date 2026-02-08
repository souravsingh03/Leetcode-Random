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
 * LeetCode: Minimum Depth of Binary Tree
 *
 * Approach:
 * - Use recursion
 * - Handle skewed trees correctly
 * - Avoid global/static variables
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If left subtree is missing, depth comes from right
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right subtree is missing, depth comes from left
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both subtrees exist
        return 1 + Math.min(
                minDepth(root.left),
                minDepth(root.right)
        );
    }
}
