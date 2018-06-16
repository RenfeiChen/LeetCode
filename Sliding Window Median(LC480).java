class Solution {
    int minHeapSize = 0, maxHeapSize = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, maxSize = k / 2;
        double[] res = new double[n - k + 1];
        TreeMap<Integer, Integer> minHeap = new TreeMap<>(), maxHeap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0) + 1);
        }
        maxHeapSize = k;
        for (int i = 0; i < maxSize; i++) {
            move(maxHeap, minHeap, false);
        }
        res[0] = getMedian(maxHeap, minHeap, k);
        for (int i = k; i < n; i++) {
            int cur = nums[i], last = nums[i - k];
            if (cur <= maxHeap.firstKey()) {
                add(maxHeap, cur, false);
            } else {
                add(minHeap, cur, true);
            }
            if (last <= maxHeap.firstKey()) {
                remove(maxHeap, last, false);
            } else {
                remove(minHeap, last, true);
            }
            while (minHeapSize < maxSize) {
                move(maxHeap, minHeap, false);
            }
            while (minHeapSize > maxSize) {
                move(minHeap, maxHeap, true);
            }
            res[i - k + 1] = getMedian(maxHeap, minHeap, k);
        }
        return res;
    }
    
    private double getMedian(TreeMap<Integer, Integer> a, TreeMap<Integer, Integer> b, int k) {
        return k % 2 == 0 ? a.firstKey() / 2.0 + b.firstKey() / 2.0 : a.firstKey() * 1.0;
    }
    
    private void move(TreeMap<Integer, Integer> a, TreeMap<Integer, Integer> b, boolean which) {
        int peek = a.firstKey();
        add(b, peek, !which);
        remove(a, peek, which);
    }
    
    private void add(TreeMap<Integer, Integer> a, int cur, boolean which) {
        a.put(cur, a.getOrDefault(cur, 0) + 1);
        if (which) {
            minHeapSize++;
        } else {
            maxHeapSize++;
        }
    }
    
    private void remove(TreeMap<Integer, Integer> a, int cur, boolean which) {
        if (a.get(cur) == 1) {
            a.remove(cur);
        } else {
            a.put(cur, a.get(cur) - 1);
        }
        if (which) {
            minHeapSize--;
        } else {
            maxHeapSize--;
        }
    }
}