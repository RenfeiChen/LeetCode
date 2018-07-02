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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode(0);
        root.left = merge(t1, t2);
        return root.left;
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2) {
        TreeNode cur;
        if (t1 != null && t2 != null) {
            cur = new TreeNode(t1.val + t2.val);
            cur.left = merge(t1.left, t2.left);
            cur.right = merge(t1.right, t2.right);
        } else if (t1 != null) {
            cur = t1;
        } else if (t2 != null) {
            cur = t2;
        } else {
            cur = null;
        }
        return cur;
    }
}