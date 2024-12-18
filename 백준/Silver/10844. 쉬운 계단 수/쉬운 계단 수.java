import java.io.*;
import java.util.*;

class Main {
    static long[][] dp;
    static long MOD = 1000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        dp = new long[N + 1][10];
        
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                
                dp[i][j] %= MOD;
            }
        }
        
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }
        
        System.out.println(result);
    }
}