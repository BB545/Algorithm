import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dist = new int[N][M];
        
        Queue<int[]> que = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 1) {
                    que.add(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1; // 미방문 상태
                }
            }
        }
        
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        
        System.out.println(maxDist);
    }
}