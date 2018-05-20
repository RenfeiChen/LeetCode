class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hours = new int[]{1, 2, 4, 8};
        int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> h = new ArrayList<>();
            List<Integer> m = new ArrayList<>();
            helper(h, hours, 0, 0, 12, i);
            helper(m, minutes, 0, 0, 60, num - i);
            for (int hour : h) {
                for (int minute : m) {
                    String hr = String.valueOf(hour), mi = "";
                    if (minute < 10) {
                        mi = "0" + String.valueOf(minute) ;
                    } else {
                        mi = String.valueOf(minute);
                    }
                    result.add(hr + ":" + mi);
                }
            }
        }
        return result;
    }
    
    private void helper(List<Integer> ans, int[] nums, int sum, int start, int target, int total) {
        if (total == 0 && sum < target) {
            ans.add(sum);
            return;
        }
        if (sum >= target || start >= nums.length || total < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            helper(ans, nums, sum + nums[i], i + 1, target, total - 1);
        }
    }
}