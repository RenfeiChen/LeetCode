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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1 = encode(s), s2 = encode(t);
        return s1.contains(s2);
    }
    
    public String encode(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        encode(root, ans);
        return ans.toString();
    }
    
    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
            return;
        }
        sb.append("," + root.val);
        encode(root.left, sb);
        encode(root.right, sb);
    }
}