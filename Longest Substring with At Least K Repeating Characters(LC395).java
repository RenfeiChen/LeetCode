class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }
    
    private int helper(String s, int k) {
        int[] record = new int[26];
        boolean finished = true;
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (record[index] != 0 && record[index] < k) {
                sb.append("#");
                finished = false;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (finished) {
            return s.length();
        }
        String[] strs = sb.toString().split("#");
        int result = 0;
        for (String str : strs) {
            result = Math.max(result, helper(str, k));
        }
        return result;
    }
}