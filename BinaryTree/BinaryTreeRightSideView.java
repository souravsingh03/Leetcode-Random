import java.util.*;

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

class Solution {

    /**
     * Returns the right side view of a binary tree.
     * Uses level-order traversal (BFS).
     *
     * @param root root of the binary tree
     * @return list of values visible from the right side
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode current = null;

            // Traverse all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // The last node processed at this level is visible from the right side
            result.add(current.val);
        }

        return result;
    }
}