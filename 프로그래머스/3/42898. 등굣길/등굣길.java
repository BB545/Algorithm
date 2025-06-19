class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int num = 1000000007;
        boolean[][] isPuddles = new boolean[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] p : puddles) {
            int i = p[0];
            int j = p[1];
            
            isPuddles[j][i] = true;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (isPuddles[i][j]) {
                    dp[i][j] = 0;
                } else {
                    if (i > 1) dp[i][j] = (dp[i - 1][j] + dp[i][j]) % num;
                    if (j > 1) dp[i][j] = (dp[i][j - 1] + dp[i][j]) % num;
                }
            }
        }
        
        return dp[n][m] % num;
    }
}