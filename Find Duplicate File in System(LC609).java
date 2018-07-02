class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String head = files[0];
            for (int i = 1; i < files.length; i++) {
                String cur = files[i];
                int contentIndex = cur.length() - 1;
                while (cur.charAt(contentIndex) != '(') {
                    contentIndex--;
                }
                String content = cur.substring(contentIndex + 1, cur.length() - 1), curPath = cur.substring(0, contentIndex);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(head + "/" + curPath);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(new ArrayList<>(map.get(key)));
            }
        }
        return result;
    }
}