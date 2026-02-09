import java.util.*;

/**
 * LeetCode: All Nodes Distance K in Binary Tree
 *
 * Approach: Using Parent Pointers + BFS
 *
 * Idea:
 * 1. Store parent of each node to allow upward traversal.
 * 2. Perform BFS starting from the target node.
 * 3. Stop BFS when distance K is reached.
 * 4. All nodes left in the queue are exactly K distance away.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

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

    // Stores parent of each node
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    /**
     * Builds parent references for every node in the tree
     */
    private void buildParentMap(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            parentMap.put(root.left, root);
            buildParentMap(root.left);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            buildParentMap(root.right);
        }
    }

    /**
     * Performs BFS from target node and collects nodes at distance K
     */
    private void bfsFromTarget(TreeNode target, int k, List<Integer> result) {

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty()) {

            int size = queue.size();

            // When k becomes 0, current queue holds answer nodes
            if (k == 0) break;

            while (size-- > 0) {
                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                if (parentMap.containsKey(current)) {
                    TreeNode parent = parentMap.get(current);
                    if (!visited.contains(parent)) {
                        queue.offer(parent);
                        visited.add(parent);
                    }
                }
            }
            k--;
        }

        // Remaining nodes are exactly K distance away
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
    }

    /**
     * Main function
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        buildParentMap(root);
        bfsFromTarget(target, k, result);

        return result;
    }
}
