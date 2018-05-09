class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        List<Integer> result = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[result.size()];
        for (i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}