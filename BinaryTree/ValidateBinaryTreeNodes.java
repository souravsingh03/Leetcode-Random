import java.util.*;

/**
 * LeetCode: Validate Binary Tree Nodes
 *
 * Approach:
 * 1. Ensure every node has at most one parent
 * 2. Ensure exactly one root exists
 * 3. Use BFS to verify:
 *    - no cycles
 *    - all nodes are connected
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // parent[i] = parent of node i, -1 if none
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // Step 1: Check for multiple parents
        for (int i = 0; i < n; i++) {

            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != -1) {
                    return false; // multiple parents found
                }
                parent[leftChild[i]] = i;
            }

            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != -1) {
                    return false; // multiple parents found
                }
                parent[rightChild[i]] = i;
            }
        }

        // Step 2: Find the root (node with no parent)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                if (root != -1) {
                    return false; // more than one root
                }
                root = i;
            }
        }

        if (root == -1) return false; // no root exists

        // Step 3: BFS to check connectivity and cycles
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);
        visited[root] = true;
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (leftChild[node] != -1) {
                if (visited[leftChild[node]]) return false; // cycle detected
                visited[leftChild[node]] = true;
                queue.offer(leftChild[node]);
                visitedCount++;
            }

            if (rightChild[node] != -1) {
                if (visited[rightChild[node]]) return false; // cycle detected
                visited[rightChild[node]] = true;
                queue.offer(rightChild[node]);
                visitedCount++;
            }
        }

        // All nodes must be reachable
        return visitedCount == n;
    }
}
