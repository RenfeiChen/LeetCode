class Solution {
    public int firstUniqChar(String s) {
        int[] record = new int[26];
        for (int i = 0; i < 26; i++) {
            record[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (record[index] == -1) {
                record[index] = i;
            } else if (record[index] == -2) {
                continue;
            } else {
                record[index] = -2;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (record[i] != -1 && record[i] != -2) {
                result = Math.min(result, record[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}