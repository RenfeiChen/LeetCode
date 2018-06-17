class Solution {
    public int[] constructRectangle(int area) {
        int sq = (int)Math.sqrt(area);
        while (area % sq != 0) {
            sq--;
        }
        return new int[] {area / sq, sq};
    }
}