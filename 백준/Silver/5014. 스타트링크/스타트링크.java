import java.io.*;
import java.util.*;

class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] dx;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        if (bfs() == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(bfs());
        }
    }
    
    public static int bfs() {
        if (G == S) return 0;
        
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[F + 1];
        dx = new int[]{U, -D};
        
        que.add(new int[]{S, 0});
        visited[S] = true;
            
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int cS = current[0];
            int cnt = current[1];
            
            for (int i = 0; i < 2; i++) {
                int nS = cS + dx[i];
                
                if (nS >= 1 && nS <= F && !visited[nS]) {
                    que.add(new int[]{nS, cnt + 1});
                    visited[nS] = true;
                    
                    if (nS == G) return cnt + 1;
                }
            }
        }
        
        return -1;
    }
}