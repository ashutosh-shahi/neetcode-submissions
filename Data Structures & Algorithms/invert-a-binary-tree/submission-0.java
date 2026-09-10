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
    public TreeNode inverted(TreeNode root) {
        if(root == null) return null;
        TreeNode left = inverted(root.left);
        TreeNode right = inverted(root.right);
        
        root.left = right;
        root.right = left;
        return root;

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        inverted(root);
        return root;
    }
}
