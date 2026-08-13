class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 2;
        for (int i = 2; i < n; i++) {
            int curr = 2;
            while (i < n && nums[i] == (nums[i - 1] + nums[i - 2])) {
                curr++;
                i++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}