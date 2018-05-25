class Solution {
    private class Trie {
        Trie[] next;
        int index;
        Trie () {
            next = new Trie[2];
            index = -1;
        }
    }
    
    private void build(String cur, Trie root, int now) {
        Trie temp = root;
        for (int i = 0; i < cur.length(); i++) {
            int index = cur.charAt(i) - '0';
            if (temp.next[index] == null) {
                temp.next[index] = new Trie();
            }
            temp = temp.next[index];
        }
        temp.index = now;
    }
    
    private int query(String cur, Trie root) {
        Trie temp = root;
        for (int i = 0; i < cur.length(); i++) {
            int index = cur.charAt(i) - '0';
            if (temp.next[1 - index] != null) {
                index = 1 - index;
            }
            temp = temp.next[index];
        }
        return temp.index;
    }
    
    public int findMaximumXOR(int[] nums) {
        String[] words = new String[nums.length];
        Trie root = new Trie();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(nums[i]));
            while (sb.length() < 31) {
                sb.insert(0, "0");
            }
            words[i] = sb.toString();
            build(words[i], root, i);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[i] ^ nums[query(words[i], root)]);
        }
        return result;
    }
}