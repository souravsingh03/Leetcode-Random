package BinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {

    /**
     * DFS helper function
     * @param root current node
     * @param deleteSet nodes to delete
     * @param forest list of remaining tree roots
     * @return TreeNode after deletion (null if deleted)
     */
    private TreeNode dfs(TreeNode root, Set<Integer> deleteSet, List<TreeNode> forest) {
        if (root == null) return null;

        // Process children first (post-order traversal)
        root.left = dfs(root.left, deleteSet, forest);
        root.right = dfs(root.right, deleteSet, forest);

        // If current node needs to be deleted
        if (deleteSet.contains(root.val)) {

            // If children exist, they become new roots
            if (root.left != null) forest.add(root.left);
            if (root.right != null) forest.add(root.right);

            return null; // delete this node
        }

        return root; // keep this node
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> deleteSet = new HashSet<>();
        for (int val : to_delete) {
            deleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();

        root = dfs(root, deleteSet, forest);

        // If root is not deleted, add it to forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }
}