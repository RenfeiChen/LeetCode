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
    List<Integer> result;
    Map<Integer, Integer> map;
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        result = new ArrayList<>();
        map = new HashMap<>();
        traverse(root);
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                result.add(key);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    
    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + traverse(root.left) + traverse(root.right);
        int count = map.getOrDefault(sum, 0) + 1;
        maxCount = Math.max(maxCount, count);
        map.put(sum, count);
        return sum;
    }
}