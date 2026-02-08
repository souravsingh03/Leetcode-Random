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

    // Global index to track current root in preorder traversal
    static int preIndex;

    /**
     * Builds binary tree using preorder and inorder traversal arrays.
     *
     * @param preorder preorder traversal array
     * @param inorder  inorder traversal array
     * @param start    start index in inorder
     * @param end      end index in inorder
     * @return root of the constructed subtree
     */
    private static TreeNode build(
            int[] preorder,
            int[] inorder,
            int start,
            int end
    ) {
        if (start > end) {
            return null;
        }

        // Pick current root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder array
        int inorderIndex = start;
        while (inorder[inorderIndex] != rootVal) {
            inorderIndex++;
        }

        // Construct left and right subtrees
        root.left = build(preorder, inorder, start, inorderIndex - 1);
        root.right = build(preorder, inorder, inorderIndex + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return build(preorder, inorder, 0, inorder.length - 1);
    }
}