class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                if (sum == ans) {
                    result.add(list2[j]);
                } else if (sum < ans) {
                    result = new ArrayList<>();
                    ans = sum;
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}