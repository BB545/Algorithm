import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();
        
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            
            char next;
            if (map[i] == 'B') next = 'O';
            else if (map[i] == 'O') next = 'J';
            else next = 'B';
            
            for (int j = i + 1; j < N; j++) {
                if (map[j] == next) {
                    int energy = (j - i) * (j - i);
                    dp[j] = Math.min(dp[j], dp[i] + energy);
                }
            }
        }
        
        int answer = dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1];
        System.out.println(answer);
    }
}