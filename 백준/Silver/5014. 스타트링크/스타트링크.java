import java.io.*;
import java.util.*;

class Main {
    static int F, U, D;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        bfs(S, G);
    }
    
    public static void bfs(int start, int end) {
        if (start == end) {
            System.out.println(0);
            return;
        }
        
        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);
        
        que.add(start);
        dist[start] = 0;
        
        while(!que.isEmpty()) {
            int current = que.poll();
            
            int[] nextLocations = {current + U, current - D};
            for (int next : nextLocations) {
                if (next > 0 && next <= F && dist[next] == -1) {
                    que.add(next);
                    dist[next] = dist[current] + 1;
                    
                    if (next == end) {
                        System.out.println(dist[next]);
                        return;
                    }
                }
            }
        }
        System.out.println("use the stairs");
        return;
    }
}