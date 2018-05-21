class Solution {
    public int longestPalindrome(String str) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] s = str.toCharArray();
        for (char c : s) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        for (char c : map.keySet()) {
            int cur = map.get(c);
            sum += cur;
            if (cur % 2 == 0) {
                result += cur;
            } else {
                result += cur - 1;
            }
        }
        if (result != sum) {
            result++;
        }
        return result;
    }
}