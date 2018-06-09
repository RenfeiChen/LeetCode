class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int[] repeatCnt = new int[s2Length + 1];
        int[] nextIndex = new int[s2Length + 1];
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int j = 0, cnt = 0;
        for (int k = 1; k <= n1; ++k) {
            for (int i = 0; i < s1Length; ++i) {
                if (s1Chars[i] == s2Chars[j]) {
                    ++j;
                    if (j == s2Length) {  
                        j = 0;
                        ++cnt;
                    }
                }
            }
            repeatCnt[k] = cnt;
            nextIndex[k] = j;
            if (map.containsKey(j)) {
                int start = map.get(j);
                int interval = k - start;
                int repeat = (n1 - start) / interval;
                int patternCnt = (repeatCnt[k] - repeatCnt[start]) * repeat;
                int remainCnt = repeatCnt[start + (n1 - start) % interval];
                return (patternCnt + remainCnt) / n2;
            }
            map.put(j, k);
        }
        return repeatCnt[n1] / n2;
        
    }
}