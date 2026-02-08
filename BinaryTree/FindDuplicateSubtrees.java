
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

/**
 * LeetCode 652: Find Duplicate Subtrees
 *
 * Approach:
 * - Serialize each subtree using postorder traversal.
 * - Use a HashMap to count frequencies of each serialization.
 * - When a serialization appears exactly twice, add the root to result.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {

    private Map<String, Integer> map;
    private List<TreeNode> result;

    private String serialize(TreeNode root) {
        if (root == null) return "N";

        StringBuilder sb = new StringBuilder();

        sb.append(root.val).append(",")
          .append(serialize(root.left)).append(",")
          .append(serialize(root.right));

        String subtree = sb.toString();

        map.put(subtree, map.getOrDefault(subtree, 0) + 1);

        // Add only once when duplicate is found
        if (map.get(subtree) == 2) {
            result.add(root);
        }

        return subtree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }
}
