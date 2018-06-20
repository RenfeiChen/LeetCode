class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        Map<Integer, Integer>[] semi = new Map[a.length], full = new Map[a.length];
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            semi[i] = new HashMap<>();
            full[i] = new HashMap<>();
            Map<Integer, Integer> curSemi = semi[i], curFull = full[i];
            for (int j = i - 1; j >= 0; j--) {
                long diff = (long)a[i] - a[j];
                if (diff > Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) {
                    continue;
                }
                curSemi.put(a[i] - a[j], curSemi.getOrDefault(a[i] - a[j], 0) + 1);
                int add = semi[j].getOrDefault(a[i] - a[j], 0) + full[j].getOrDefault(a[i] - a[j], 0);
                curFull.put(a[i] - a[j], curFull.getOrDefault(a[i] - a[j], 0) + add);
                result += add;
            }
        }
        return result;
    }
}