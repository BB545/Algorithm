import java.io.*;
import java.util.*;

class Main {
    static final int MOD = 1000000009;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        dp = new int[100001][4];
        initDP();
        
        while(T-- > 0) {
            // 목표 정수값
            int n = Integer.parseInt(br.readLine());
            int result = ((dp[n][1] + dp[n][2]) % MOD + dp[n][3]) % MOD;
            
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
    
    // dp 초기화
    public static void initDP() {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][1] = 1; // 1+2
        dp[3][2] = 1; // 2+1

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 마지막 1로 끝난 경우의 수 점화식
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD; // 마지막 2로 끝난 경우의 수 점화식
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD; // 마지막 3으로 끝난 경우의 수 점화식
        }
    }
}