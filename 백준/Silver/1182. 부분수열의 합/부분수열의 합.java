import java.io.*;
import java.util.*;

class Main {
    static int N, S;
    static int[] seq;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0, 0);
        System.out.println(cnt);
    }
    
    public static void dfs(int index, int sum, int selec) {
        if (index == N) {
            if (sum == S && selec > 0) { // 선택한 갯수 1개 이상일 때 - 공집합 제외
                cnt++;
            }
            return;
        }
        
        dfs(index + 1, sum + seq[index], selec + 1); // 현재 요소 포함 경우
        dfs(index + 1, sum, selec); // 현재 요소 미포함 경우
    }
}