class Solution {
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])");
        int[][] nums = new int[fracs.length][2];
        int deno = 1;
        for (int i = 0; i < fracs.length; i++) {
            String[] cur = fracs[i].split("/");
            nums[i][0] = Integer.parseInt(cur[0]);
            nums[i][1] = Integer.parseInt(cur[1]);
            deno = deno * nums[i][1] / gcd(deno, nums[i][1]);
        }
        int result = 0;
        for (int i = 0; i < fracs.length; i++) {
            result += nums[i][0] * (deno / nums[i][1]);
        }
        if (result == 0) {
            return "0/1";
        }
        int temp = gcd(result, deno);
        temp = temp < 0 ? -temp : temp;
        return (result / temp) + "/" + (deno / temp);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}