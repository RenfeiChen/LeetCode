class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            minutes[i] = Integer.parseInt(timePoints.get(i).substring(0,2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(minutes);
        for (int i = 1; i < minutes.length; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }
        result = Math.min(result, minutes[0] + 1440 - minutes[minutes.length - 1]);
        return result;
    }
}