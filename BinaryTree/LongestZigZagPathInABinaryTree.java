package BinaryTree;
/**
 * LeetCode: Longest ZigZag Path in a Binary Tree
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)  // recursion stack
 *
 * Where:
 * N = number of nodes
 * H = height of the tree
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

public class LongestZigZagPathInABinaryTree {

    private int maxPath = 0;

    /**
     * DFS returns an array:
     * index 0 -> longest zigzag ending by moving LEFT
     * index 1 -> longest zigzag ending by moving RIGHT
     */
    private int[] dfs(TreeNode node) {
        if (node == null) {
            // -1 so that +1 becomes 0 at parent
            return new int[]{-1, -1};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we go left, previous move must be right
        int leftZigZag = left[1] + 1;

        // If we go right, previous move must be left
        int rightZigZag = right[0] + 1;

        maxPath = Math.max(maxPath, Math.max(leftZigZag, rightZigZag));

        return new int[]{leftZigZag, rightZigZag};
    }

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxPath;
    }
}
