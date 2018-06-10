class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        char[] c = p.toCharArray();
        int sum = 0, maxLen = 1;
        for (int i = 0; i < c.length; i++) {
            if (i > 0 && (c[i] == c[i - 1] + 1 || c[i] + 25 == c[i - 1])) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            count[c[i] - 'a'] = Math.max(count[c[i] - 'a'], maxLen);
        }
        for (int cnt : count) {
            sum += cnt;
        }
        return sum;
    }
}