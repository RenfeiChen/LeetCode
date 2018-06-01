class Solution {
    public String frequencySort(String s) {
        TreeMap<Integer, List<Character>> map = new TreeMap<>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (Character c : count.keySet()) {
            int times = count.get(c);
            if (!map.containsKey(times)) {
                map.put(times, new ArrayList<>());
            }
            map.get(times).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int times : map.keySet()) {
            for (Character c : map.get(times)) {
                for (int i = 0; i < times; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.reverse().toString();
    }
}