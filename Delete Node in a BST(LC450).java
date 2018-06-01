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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode newRoot = new TreeNode(0), pre = newRoot;
        boolean dir = true;
        newRoot.left = root;
        while (root != null) {
            if (root.val < key) {
                pre = root;
                dir = false;
                root = root.right;
            } else if (root.val > key) {
                pre = root;
                dir = true;
                root = root.left;
            } else {
                break;
            }
        }
        if (root == null) {
            return newRoot.left;
        }
        if (root.right == null) {
            if (dir == true) {
                pre.left = root.left;
            } else {
                pre.right = root.left;
            }
            return newRoot.left;
        }
        if (root.left == null) {
            if (dir == true) {
                pre.left = root.right;
            } else {
                pre.right = root.right;
            }
            return newRoot.left;
        }
        TreeNode rightChild = root.right;
        root = root.left;
        if (dir == true) {
            pre.left = root;
        } else {
            pre.right = root;
        }
        while (root.right != null) {
            root = root.right;
        }
        root.right = rightChild;
        return newRoot.left;
    }
}