class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        StringBuilder part = new StringBuilder();
        boolean hasRev = false;
        for (int i = 0; i < s.length(); i++) {
            part.append(s.charAt(i));
            if ((i + 1) % k == 0) {
                if ((i + 1) % (2 * k) != 0) {
                    result.append(part.reverse());
                    hasRev = true;
                } else {
                    result.append(part);
                    hasRev = false;
                }
                part = new StringBuilder();
            }
        }
        if (hasRev) {
            result.append(part);
        } else {
            result.append(part.reverse());
        }
        return result.toString();
        
    }
}