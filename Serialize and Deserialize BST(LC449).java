/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] preStr = data.split(" ");
        String[] inStr = new String[preStr.length];
        int[] preOrder = new int[preStr.length];
        int[] inOrder = new int[preStr.length];
        for (int i = 0; i < preStr.length; i++) {
            preOrder[i] = Integer.parseInt(preStr[i]);
            inOrder[i] = preOrder[i];
        }
        Arrays.sort(inOrder);
        return reconstruct(0, 0, inOrder.length - 1, preOrder, inOrder);
    }
    
    private TreeNode reconstruct(int preIndex, int inStart, int inEnd, int[] pre, int[] in) {
        if (preIndex > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        int cur = pre[preIndex];
        TreeNode root = new TreeNode(cur);
        int left = 0, right = in.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (in[mid] < cur) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        root.left = reconstruct(preIndex + 1, inStart, left - 1, pre, in);
        root.right = reconstruct(preIndex + left - inStart + 1, left + 1, inEnd, pre, in);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));