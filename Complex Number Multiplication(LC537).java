class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] num1 = decode(a), num2 = decode(b);
        return (num1[0] * num2[0] - num1[1] * num2[1]) + "+" + (num1[0] * num2[1] + num1[1] * num2[0]) + "i";
    }
    
    private int[] decode(String s) {
        String[] strs = s.split("\\+");
        int[] ans = new int[2];
        ans[0] = Integer.parseInt(strs[0]);
        ans[1] = Integer.parseInt(strs[1].substring(0, strs[1].length() - 1));
        return ans;
    }
}