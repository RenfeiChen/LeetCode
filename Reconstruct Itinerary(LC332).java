class Solution {
    boolean found = false;
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = tickets.length;
        if (n == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        dfs(result, map, "JFK");
        return result;
    }
    
    private void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String cur) {
        while (map.get(cur) != null && map.get(cur).size() != 0) {
            dfs(result, map, map.get(cur).poll());
        }
        result.add(0, cur);
    }
}