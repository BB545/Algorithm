import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int N;
    static int[][] dist;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(r1, c1, r2, c2));
    }
    
    public static int bfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) return 0;
        
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[N][N];
        dist = new int[N][N];
        
        que.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    
                    if (nx == endX && ny == endY) {
                        return dist[nx][ny];
                    }
                }
            }
        }
        return -1;
    }
}