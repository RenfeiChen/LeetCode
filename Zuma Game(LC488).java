class Solution {
    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
        }
        int result = helper(board + "#", count);
        return result == 6 ? -1 : result;
    }
    
    private int helper(String board, int[] count) {
        if (board.equals("#")) {
            return 0;
        }
        int result = 6;
        for (int i = 0, j = 0; i < board.length(); i++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }
            int need = 3 - (i - j), index = board.charAt(i - 1) - 'A';
            if (need <= count[index]) {
                count[index] -= need;
                String cur = remove(board.substring(0, j) + board.substring(i));
                result = Math.min(result, need + helper(cur, count));
                count[index] += need;
            }
            j = i;
        }
        return result;
    }
    
    private String remove(String s) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            if (i - j >= 3) {
                return remove(s.substring(0, j) + s.substring(i));
            } else {
                j = i;
            }
        }
        return s;
    }
}