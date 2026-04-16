class Solution {
    private int burst(int N,Integer dp[][],int nums[],int left,int right){
        if(left>right) return 0;
        if(dp[left][right]!=null) return dp[left][right];
        int maxpts=0;
        for(int i=left;i<=right;i++){
            int currpts=burst(N,dp,nums,left,i-1)+burst(N,dp,nums,i+1,right);
            int lastburst=(left-1>=0?nums[left-1]:1)*nums[i]*(right+1<N?nums[right+1]:1);
            currpts+=lastburst;
            maxpts=Math.max(maxpts,currpts);
        } 
        dp[left][right]=maxpts;
        return maxpts;
    }
    public int maxCoins(int[] nums) {
        int N=nums.length;
        Integer dp[][]=new Integer[N][N];
        return burst(N,dp,nums,0,N-1);
    }
}
