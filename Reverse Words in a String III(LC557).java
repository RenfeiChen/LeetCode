class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String str : s.split(" ")) {
            StringBuilder temp = new StringBuilder(str);
            result.append(temp.reverse()).append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}