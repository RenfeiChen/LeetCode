class Solution {
    public String addStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, add = 0;
        char[] num1 = s1.toCharArray(), num2 = s2.toCharArray();
        while (i >= 0 || j >= 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = num1[i] - '0';
            }
            if (j >= 0) {
                n2 = num2[j] - '0';
            }
            sb.append((n1 + n2 + add) % 10);
            if (n1 + n2 + add >= 10) {
                add = 1;  
            } else {
                add = 0;
            }
            i--;
            j--;
        }
        if (add == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}