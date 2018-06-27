class Solution {
    public boolean checkRecord(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            } else if (c == 'L') {
                if (i < s.length() - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}