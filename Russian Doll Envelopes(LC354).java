class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
        int size = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < envelopes[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = envelopes[i][1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}