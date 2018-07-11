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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = getHeight(root);
        // System.out.println(height);
        helper(root, 0, result, height);
        // for (int i = 0; i <= height; i++) {
        //     List<String> cur = result.get(i);
        //     while (cur.size() < (int)Math.pow(2, height + 1) - 1) {
        //         cur.add("");
        //     }
        // }
        return result;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    private void helper(TreeNode root, int depth, List<List<String>> result, int height) {
        if (root == null && depth > height) {
            return;
        }
        boolean flag = true;
        if (result.size() <= depth) {
            result.add(new ArrayList<>());
            flag = false;
        }
        int cur = (int)Math.pow(2, height - depth) - 1;
        String value = "";
        if (root != null) {
            value += root.val;
        }
        if (flag) {
            result.get(depth).add("");
        }
        for (int i = 0; i < cur; i++) {
            result.get(depth).add("");
        }
        result.get(depth).add(value);
        for (int i = 0; i < cur; i++) {
            result.get(depth).add("");
        }
        TreeNode left = root == null ? null : root.left;
        TreeNode right = root == null ? null : root.right;
        helper(left, depth + 1, result, height);
        helper(right, depth + 1, result, height);

    }
}