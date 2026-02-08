
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
     * Recursively inserts a new row at the given depth.
     */
    private TreeNode insertRow(TreeNode node, int val, int targetDepth, int currentDepth) {
        if (node == null) {
            return null;
        }

        // When we reach depth - 1, insert new nodes
        if (currentDepth == targetDepth - 1) {
            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;

            node.left = new TreeNode(val);
            node.right = new TreeNode(val);

            node.left.left = oldLeft;
            node.right.right = oldRight;

            return node;
        }

        node.left = insertRow(node.left, val, targetDepth, currentDepth + 1);
        node.right = insertRow(node.right, val, targetDepth, currentDepth + 1);

        return node;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: insert new root
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return insertRow(root, val, depth, 1);
    }
}
