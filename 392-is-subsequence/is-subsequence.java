class Solution {
    static int[][]dp;
    public int LCS(String s, String t){
        int m=s.length();
        int n=t.length();
        dp=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                
                }}}
        return dp[m][n];
    }
    public boolean isSubsequence(String s, String t) {
        int x=LCS(s,t);
        return x == s.length();
    }
}