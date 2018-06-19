class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length, result = W;
        int[][] pair = new int[n][2];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pair[i][1] = Profits[i];
            pair[i][0] = Capital[i];
        }
        Arrays.sort(pair, new Comparator<int[]>() {
           public int compare (int[] a, int[] b) {
               return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
           } 
        });
        int i = 0;
        while (k > 0) {
            while (i < n && pair[i][0] <= result) {
                map.put(pair[i][1], map.getOrDefault(pair[i][1], 0) + 1);
                i++;
            }
            if (map.size() == 0) {
                return result;
            }
            k--;
            int cur = map.firstKey();
            if (map.get(cur) == 1) {
                map.remove(cur);
            } else {
                map.put(cur, map.get(cur) - 1);
            }
            result += cur;
        }
        return result;
    }
}