import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String row = br.readLine().trim();
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        
        visited = new boolean[N][M];
        System.out.println(bfs(0, 0));
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            int cnt = current[2];
            
            if (cx == N - 1 && cy == M - 1) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}