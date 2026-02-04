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

    /* =====================================================
       BFS APPROACH (Level Order Traversal)
       ===================================================== */

    /**
     * A binary tree is complete if:
     * After the first null appears in level order traversal,
     * no non-null node appears afterwards.
     */
    public boolean isCompleteTreeBFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean seenNull = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                seenNull = true;
            } else {
                // If a non-null node appears after a null
                if (seenNull) return false;

                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }

    /* =====================================================
       DFS APPROACH (Index Mapping)
       ===================================================== */

    /**
     * Counts total number of nodes in the tree.
     */
    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    /**
     * DFS traversal with 1-based index mapping.
     *
     * Index rules:
     * root        -> 1
     * left child  -> 2 * index
     * right child -> 2 * index + 1
     *
     * If any node gets an index greater than total nodes,
     * the tree is NOT complete.
     */
    public static boolean dfs(TreeNode root, int index, int totalNodes) {
        if (root == null) {
            return true;
        }

        if (index > totalNodes) {
            return false;
        }

        return dfs(root.left, 2 * index, totalNodes) &&
               dfs(root.right, 2 * index + 1, totalNodes);
    }

    /**
     * Main DFS-based completeness check.
     */
    public boolean isCompleteTreeDFS(TreeNode root) {
        int totalNodes = count(root);
        return dfs(root, 1, totalNodes);
    }
}