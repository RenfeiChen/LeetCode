class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey();
            }
        });
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        pq.addAll(map.entrySet());
        int result = 0;
        while (!pq.isEmpty()) {
            int k = n;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            while (k >= 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> cur = pq.poll();
                cur.setValue(cur.getValue() - 1);
                if (cur.getValue() > 0) {
                    list.add(cur);
                }
                k--;
                result++;
            }
            pq.addAll(list);
            if(pq.isEmpty()) {
                break;
            }
            result += k + 1;
        }
        return result;
    }
}