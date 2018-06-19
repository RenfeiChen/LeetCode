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
    int maxCount = 0, preVal = 0, curCount;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (preVal != root.val) {
            curCount = 0;
            preVal = root.val;
        }
        curCount++;
        if (curCount > maxCount) {
            result.clear();
            maxCount = curCount;
            result.add(root.val);
        } else if (curCount == maxCount) {
            result.add(root.val);
        }
        helper(root.right);
    }
}