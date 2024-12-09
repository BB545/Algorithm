import java.io.*;
import java.util.*;

class Main {
    static int K, I;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());
        
        while (K-- > 0) {
            I = Integer.parseInt(br.readLine().trim());
            String[] start = br.readLine().trim().split(" ");
            String[] end = br.readLine().trim().split(" ");
            
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);
            
            System.out.println(bfs(startX, startY, endX, endY));
        }
    }
    
    public static int bfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) return 0;
        
        visited = new boolean[I][I];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            int cnt = current[2];
            
            if (cx == endX && cy == endY) {
                return cnt;
            }
            
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]) {
                    
                    que.add(new int[]{nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}