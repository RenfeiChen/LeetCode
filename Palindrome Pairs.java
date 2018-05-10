class Solution {
    
    private class Trie {
        Trie[] child;
        int index;
        List<Integer> list;
        Trie() {
            child = new Trie[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    
    private void build(Trie root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int cur = word.charAt(i) - 'a';
            if (root.child[cur] == null) {
                root.child[cur] = new Trie();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.child[cur];
        }
        root.list.add(index);
        root.index = index;
    }
    
    private void search(Trie root, String word, int index, List<List<Integer>> result) {
        for (int i = 0; i < word.length(); i++) {
            if (root.index >= 0 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                result.add(Arrays.asList(index, root.index));
            }
            int cur = word.charAt(i) - 'a';
            root = root.child[cur];
            if (root == null) {
                return;
            }
        }
        for (int i : root.list) {
            if (i == index) {
                continue;
            }
            result.add(Arrays.asList(index, i));
        }
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words.length < 2) {
            return result;
        }
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            build(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, result);
        }
        return result;
    }
}