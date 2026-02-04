package BinaryTree;
import java.util.*;

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

    // Stores all valid root-to-leaf paths
    private List<List<Integer>> result;

    /**
     * DFS helper to find all root-to-leaf paths with given sum
     */
    private void dfs(TreeNode root, int targetSum, int currentSum, List<Integer> path) {
        if (root == null) {
            return;
        }

        // Include current node
        currentSum += root.val;
        path.add(root.val);

        // Check if leaf node
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                // Add a copy of the current path
                result.add(new ArrayList<>(path));
            }
        } else {
            // Explore left and right subtrees
            dfs(root.left, targetSum, currentSum, path);
            dfs(root.right, targetSum, currentSum, path);
        }

        // Backtrack to explore other paths
        path.remove(path.size() - 1);
    }

    /**
     * Returns all root-to-leaf paths where sum of values equals targetSum
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }
}
