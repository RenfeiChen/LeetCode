class Solution {
    public int findMinMoves(int[] machines) {
        int cnt = 0, result = Integer.MIN_VALUE, sum = 0;
        for (int num : machines) {
            sum += num;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        sum /= machines.length;
        for (int num : machines) {
            num -= sum;
            cnt += num;
            result = Math.max(result, Math.max(Math.abs(cnt), num));
        }
        return result;
    }
}.