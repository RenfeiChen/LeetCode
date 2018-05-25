class Solution {
      public int characterReplacement(String s, int k) {
          int n = s.length(), start = 0, result = 0, max = 0;
          int[] count = new int[26];
          for (int i = 0; i < n; i++) {
              count[s.charAt(i) - 'A']++;
              max = Math.max(max, count[s.charAt(i) - 'A']);
              if (i - start + 1 - max > k) {
                  count[s.charAt(start) - 'A']--;
                  start++;
              }
              result = Math.max(result, i - start + 1);
          }
          return result;
    }
}