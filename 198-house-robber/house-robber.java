class Solution {
    static int[]dp;
    public int rob(int[] nums) { 
       dp=new int[nums.length];
       for (int i = 0; i < nums.length; i++) {
           dp[i] = -1;
       }
       return backtrack(nums,0);
    }
    private int backtrack(int[] nums, int n){
      if(n>=nums.length)return 0;
            if(dp[n]!=-1) return dp[n];
      //select ith index , then i+2
      int selecthouse=nums[n] + backtrack(nums,n+2);
      //skip the house and move to the next
       int skiphouse=backtrack(nums,n+1);
            
       //return the max of two choices
       return dp[n]= Math.max(selecthouse,skiphouse);
    }
}