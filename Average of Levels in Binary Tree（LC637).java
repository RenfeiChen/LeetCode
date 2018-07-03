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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), deno = size;
            long sum = 0;
            while (size > 0) {
                size--;
                TreeNode cur = queue.poll();
                sum += (long)cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(sum * 1.0 / deno);
        }
        return result;
    }
}