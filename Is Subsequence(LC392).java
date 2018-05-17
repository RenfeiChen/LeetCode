class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] record = new List[26];
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (record[index] == null) {
                record[index] = new ArrayList<>();
            }
            record[index].add(i);
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (record[index] == null) {
                return false;
            }
            int left = 0, right = record[index].size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (record[index].get(mid) < pos) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == record[index].size()) {
                return false;
            }
            pos = record[index].get(left) + 1;
        }
        return true;
    }
}