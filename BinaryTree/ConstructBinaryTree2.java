/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBinaryTree2 {

    /**
     * Builds the binary tree using inorder and postorder traversal.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return constructTree(
                inorder,
                postorder,
                0, n - 1,      // inorder range
                0, n - 1       // postorder range
        );
    }

    /**
     * Recursive helper to construct the tree.
     */
    private TreeNode constructTree(
            int[] inorder,
            int[] postorder,
            int inStart,
            int inEnd,
            int postStart,
            int postEnd) {

        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element in postorder is the root
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Find root index in inorder traversal
        int rootIndex = inStart;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }

        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = constructTree(
                inorder,
                postorder,
                inStart,
                rootIndex - 1,
                postStart,
                postStart + leftSize - 1
        );

        root.right = constructTree(
                inorder,
                postorder,
                rootIndex + 1,
                inEnd,
                postStart + leftSize,
                postEnd - 1
        );

        return root;
    }
}
