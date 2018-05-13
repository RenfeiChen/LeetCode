class Solution {
    private final int MOD = 1337;
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length - 1);
    }
    
    private int power(int a, int lastDigit) {
        int result = 1;
        a = a % MOD;
        for (int i = 0; i < lastDigit; i++) {
            result = result * a % MOD;
        }
        return result;
    }
    
    private int helper(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        int lastDigit = b[index];
        return power(helper(a, b, index - 1), 10) % MOD * power(a, lastDigit) % MOD;
    }
}