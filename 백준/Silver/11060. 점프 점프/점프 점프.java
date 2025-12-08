import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // 도달 불가능한 칸 스킵
            
            for (int j = i + 1; j <= i + line[i] && j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        
        int result = dp[N] == Integer.MAX_VALUE ? -1 : dp[N];
        System.out.println(result);
    }
}