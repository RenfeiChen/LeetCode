class Solution {
    public String nearestPalindromic(String s) {
        // get the half, half - 1, half + 1 candidates and flip, append them
        int n = s.length(), half = (n + 1) / 2;
        // if (n == 1) {
        //     return String.valueOf(Integer.parseInt(s) - 1);
        // }
        long halfNum = Long.parseLong(s.substring(0, half));
        boolean even = n % 2 == 0;
        List<Long> list = new ArrayList<>();
        helper(list, halfNum, even);
        helper(list, halfNum - 1, even);
        helper(list, halfNum + 1, even);
        list.add((long)Math.pow(10, n) + 1);
        list.add((long)Math.pow(10, n - 1) - 1);
        // for (long num : list) {
        //     System.out.println(num);
        // }
        long minDif = Long.MAX_VALUE, origin = Long.parseLong(s), result = 0;
        for (long num : list) {
            if (num == origin) {
                continue;
            }
            long dif = Math.abs(num - origin);
            if (dif < minDif) {
                minDif = dif;
                result = num;
            } else if (dif == minDif) {
                result = Math.min(num, result);
            }
        }
        return result + "";
    }
    
    private void helper(List<Long> list, long num, boolean even) {
        StringBuilder left = new StringBuilder(num + "");
        StringBuilder right = new StringBuilder(num + "");
        left.append(right.reverse());
        if (!even) {
            left.deleteCharAt((left.length() + 1) / 2);
        }
        list.add(Long.parseLong(left.toString()));
    }
}