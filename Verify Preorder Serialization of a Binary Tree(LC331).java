class Solution {
    public boolean isValidSerialization(String preorder) {
        int size = 0, i = 0;
        String[] strs = preorder.split(",");
        for (; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                if (size == 0) {
                    break;
                }
                size--;
            } else {
                size++;
            }
        }
        return size == 0 && i == strs.length - 1 && strs[i].equals("#");
    }
}