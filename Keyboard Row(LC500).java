class Solution {
    public String[] findWords(String[] words) {
        String[] s = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] count = new int[26];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                count[s[i].charAt(j) - 'a'] = i;
            }
        }
        List<String> result = new ArrayList<>();
        for (String oriWord : words) {
            String word = oriWord.toLowerCase();
            boolean check = true;
            for (int i = 0; i < word.length(); i++) {
                if (count[word.charAt(i) - 'a'] != count[word.charAt(0) - 'a']) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result.add(oriWord);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}