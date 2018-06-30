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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) {
            return sb.toString();
        }
        helper(t, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);
        return sb.toString();
    }
    
    private void helper(TreeNode root, StringBuilder sb) {
        sb.append("(" + root.val);
        if (root.left != null) {
            helper(root.left, sb);
            if (root.right != null) {
                helper(root.right, sb);
            }
        } else if (root.right != null) {
            sb.append("()");
            helper(root.right, sb);
        }
        sb.append(")");
    }
}