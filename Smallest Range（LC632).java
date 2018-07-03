class Solution {
    private class node {
        int index;
        int pos;
        int value;
        node (int index, int pos, int value) {
            this.index = index;
            this.pos = pos;
            this.value = value;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            public int compare (node a, node b) {
                return a.value - b.value;
            }
        });
        int max = Integer.MIN_VALUE, range = Integer.MAX_VALUE, n = nums.size();;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            pq.offer(new node(i, 0, nums.get(i).get(0)));
            max = Math.max(nums.get(i).get(0), max);
        }
        while (pq.size() == n) {
            node cur = pq.poll();
            if (range > max - cur.value) {
                range = max - cur.value;
                result[0] = cur.value;
                result[1] = max;
            }
            if (cur.pos + 1 < nums.get(cur.index).size()) {
                int v = nums.get(cur.index).get(cur.pos + 1);
                node next = new node(cur.index, cur.pos + 1, v);
                pq.offer(next);
                max = Math.max(v, max);
            }
        }
        return result;
    }
}