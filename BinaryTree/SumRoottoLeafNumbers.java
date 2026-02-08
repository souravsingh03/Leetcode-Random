
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
 * Computes the sum of all numbers formed by root-to-leaf paths.
 * Each path is treated as a number formed by concatenating node values.
 */
public class SumRoottoLeafNumbers {

    /**
     * Helper method to perform DFS and build numbers along the path.
     *
     * @param node current tree node
     * @param currentNumber number formed so far
     * @return sum of all root-to-leaf numbers from this node
     */
    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        // Append current node value to the number
        currentNumber = currentNumber * 10 + node.val;

        // If leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Recur for left and right subtrees
        return dfs(node.left, currentNumber) + dfs(node.right, currentNumber);
    }

    /**
     * Main function called by the judge.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}
