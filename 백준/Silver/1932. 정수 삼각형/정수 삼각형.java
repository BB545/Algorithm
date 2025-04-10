import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] tr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n][n];
        dp[0][0] = tr[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + tr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + tr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + tr[i][j];
                }
            }
        }
        
        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n - 1][j]); // 마지막행에서 최댓값
        }
        
        System.out.println(max);
    }
}