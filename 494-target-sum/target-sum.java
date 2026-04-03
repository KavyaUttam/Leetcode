class Solution {
    static int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        count=0;
        solve(nums,target,0,0);
        return count;
    }
    public static void solve(int nums[],int target,int i,int sum){
        if(i==nums.length){
            if(sum==target){
            count++;
        }
            return;
        }
        solve(nums,target,i+1,sum-nums[i]);
        solve(nums,target,i+1,sum+nums[i]);
    }
}