class Solution {
    public int numTrees(int n) {
  int [] dp= new int[n+1];
  dp[0] = dp[1] = 1;
    
  for(int i=2; i<=n; i++) {
    int l=0;
    int r=i-1;
    int res=0;
    while(l<=r){
        if(l==r){
            res+=dp[l]*dp[r];
        }
        else{
           res+=2*(dp[l]*dp[r]);
        }
    
    l++;
    r--;
    }
     dp[i] = res;
  }
  return dp[n];
}
}