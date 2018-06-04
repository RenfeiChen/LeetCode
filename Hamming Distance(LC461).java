class Solution {
    public int hammingDistance(int x, int y) {
        String x1 = Integer.toBinaryString(x);
        String y1 = Integer.toBinaryString(y);
        int n = x1.length(), m = y1.length(), result = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            char s1 = i < n ? x1.charAt(n - i - 1) : '0';
            char s2 = i < m ? y1.charAt(m - i - 1) : '0';
            result += Math.abs(s1 - s2);
        }
        return result;
    }
}