class Solution {
    public String licenseKeyFormatting(String s, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            sb.append(c);
            count++;
            if (count == K) {
                count = 0;
                sb.append("-");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1); 
        }
        return sb.reverse().toString().toUpperCase();
    }
}