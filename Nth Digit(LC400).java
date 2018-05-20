class Solution {
    public int findNthDigit(int m) {
        long start = 1, count = 9, n = m;
        int len = 1;
        while (n > len * count) {
            n -= len * count;
            start *= 10;
            len++;
            count *= 10;
        }
        start += (n - 1) / len;
        int digit = (int)(len - (n - 1) % len - 1);
        for (int i = 0; i < digit; i++) {
            start /= 10;
        }
        return (int)(start % 10);
    }
}