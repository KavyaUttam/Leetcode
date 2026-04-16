class Solution {
     static int[][] dp;

    public static int LCS(String s, String s2) {
        int m = s.length();
        int n = s2.length();

        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
    public static int longestPalinSubseq(String s) {
       String s2 = new StringBuilder(s).reverse().toString();
		return LCS(s,s2); 
    }
    public int minInsertions(String s) {
      return s.length()-longestPalinSubseq(s);  
    }
}