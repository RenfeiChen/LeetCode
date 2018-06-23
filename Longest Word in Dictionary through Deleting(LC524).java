class Solution {
    public String findLongestWord(String s2, List<String> d) {
        String[] strs = d.toArray(new String[d.size()]);
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length();
            }
        });
        for (String s1 : strs) {
            if (check(s1, s2)) {
                return s1;
            }
        }
        return "";
    }
    
    private boolean check(String s1, String s2) {
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