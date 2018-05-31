class Solution {
    public int compress(char[] chars) {
        int n = chars.length, len = 1;
        if (n <= 1) {
            return n;
        }
        int repeat = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                repeat++;
            } else {
                if (repeat != 1) {
                    StringBuilder cur = new StringBuilder();
                    while (repeat != 0) {
                        cur.append(repeat % 10);
                        repeat /= 10;
                    }
                    cur = cur.reverse();
                    for (int j = 0; j < cur.length(); j++) {
                        len++;
                        chars[len - 1] = cur.charAt(j);
                    }
                }
                repeat = 1;
                len++;
                chars[len - 1] = chars[i];
            }
        }
        if (repeat != 1) {
            StringBuilder cur = new StringBuilder();
            while (repeat != 0) {
                cur.append(repeat % 10);
                repeat /= 10;
            }
            cur = cur.reverse();
            for (int j = 0; j < cur.length(); j++) {
                len++;
                chars[len - 1] = cur.charAt(j);
            }
        }
        return len;
    }
}