class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!works(mid, houses, heaters)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private boolean works(int radius, int[] houses, int[] heaters) {
        int p1 = 0, p2 = 0;
        while (p1 < houses.length && p2 < heaters.length) {
            if (heaters[p2] - radius > houses[p1]) {
                return false;
            } else if (heaters[p2] + radius < houses[p1]) {
                p2++;
            } else {
                p1++;
            }
        }
        return p1 == houses.length;
    }
}