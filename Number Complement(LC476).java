class Solution {
    public int findComplement(int num) {
        int i = 0, sum = 0;
        while (sum < num) {
            sum += Math.pow(2, i);
            i++;
        }
        return sum - num;
    }
}