class Solution {    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        List<String> result = new ArrayList<>();
        Set<String> templates = new HashSet<>();
        for (String word : words) {
            if (isConcatednatedWords(word, templates)) {
                result.add(word);
            }
            templates.add(word);
        }
        return result;
    }
    
    private boolean isConcatednatedWords(String word, Set<String> templates) {
        if (templates.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && templates.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}