class Solution {
    static int[]dp;
    public int rob(int[] nums) { 
        int n=nums.length;
       dp=new int[n+1];
       for (int i = 0; i < nums.length; i++) {
           dp[i] = 0;
       }
       dp[0]=0;
       dp[1]=nums[0];
       for(int i=2;i<=n;i++){
        dp[i]=Math.max(dp[i-2] + nums[i-1], dp[i-1]);
       }
       return dp[n];
    }
    
}