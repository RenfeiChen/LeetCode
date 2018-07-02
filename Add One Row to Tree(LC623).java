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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode newRoot = new TreeNode(0);
        newRoot.left = root;
        queue.offer(newRoot);
        while (!queue.isEmpty()) {
            if (d == 1) {
                helper(queue, v);
                return newRoot.left;
            } else {
                int size = queue.size();
                while (size > 0) {
                    size--;
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                d--;
            }
        }
        helper(queue, v);
        return newRoot.left;
    }
    
    private void helper(Queue<TreeNode> queue, int v) {
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll(), left = cur.left, right = cur.right;
            TreeNode newLeft = new TreeNode(v), newRight = new TreeNode(v);
            cur.left = newLeft;
            newLeft.left = left;
            newLeft.right = null;
            cur.right = newRight;
            newRight.left = null;
            newRight.right = right;
        }
    }
}