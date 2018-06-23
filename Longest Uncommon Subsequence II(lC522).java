class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() == s2.length() ? 1 : s1.length() - s2.length();
            }
        });
        for (int i = strs.length - 1; i >= 0; i--) {
            if (check(strs[i], strs, i)) {
                return strs[i].length();
            }
        }
        return -1;
    }
    
    private boolean check(String s, String[] strs, int index) {
        for (int i = strs.length - 1; i >= 0; i--) {
            if (i == index) {
                continue;
            }
            if (strs[i].length() < s.length()) {
                break;
            }
            if (isSub(s, strs[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSub(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (j < s2.length() && s2.charAt(j) != s1.charAt(i)) {
                j++;
            }
            if (j == s2.length()) {
                return false;
            }
            j++;
        }
        return true;
    }
}