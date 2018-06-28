class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int index = s.length() - 1;
        while (index > 0 && s.charAt(index) <= s.charAt(index - 1)) {
            index--;
        }
        if (index == 0) {
            return -1;
        }
        index--;
        int rec = index;
        for (int i = s.length() - 1; i > index; i--) {
            if (s.charAt(i) > s.charAt(index)) {
                rec = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(0, index));
        sb.append(s.charAt(rec));
        boolean flag = true;
        for (int i = s.length() - 1; i >= index + 1; i--) {
            if (i == rec) {
                continue;
            }
            if (flag && s.charAt(i) >= s.charAt(index)) {
                sb.append(s.charAt(index));
                flag = false;
            }
            sb.append(s.charAt(i));
        }
        if (flag) {
            sb.append(s.charAt(index));
        }
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }
}