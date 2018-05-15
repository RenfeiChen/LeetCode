class Solution {
    
    int[] origin;
    Random rand;

    public Solution(int[] nums) {
        this.origin = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            origin[i] = nums[i];
        }
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] cur = this.origin.clone();
        for (int i = 1; i < cur.length; i++) {
            int next = rand.nextInt(i + 1);
            int temp = cur[i];
            cur[i] = cur[next];
            cur[next] = temp;
        }
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */