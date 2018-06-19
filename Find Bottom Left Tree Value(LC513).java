/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int depth = -1, result = 0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (cur > depth) {
                depth = cur;
                result = root.val;
            }
            return;
        }
        helper(root.left, cur + 1);
        helper(root.right, cur + 1);
    }
}