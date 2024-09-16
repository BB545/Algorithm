import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        int[][] map = new int[101][101];
        int[][] visited = new int[101][101];
        boolean[][] check = new boolean[101][101];
        
        for (int[] point : rectangle) {
            int lx = point[0] * 2;
            int ly = point[1] * 2;
            int rx = point[2] * 2;
            int ry = point[3] * 2;
            
            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] point : rectangle) {
            int lx = point[0] * 2;
            int ly = point[1] * 2;
            int rx = point[2] * 2;
            int ry = point[3] * 2;
            
            for (int i = lx + 1; i < rx; i++) {
                for (int j = ly + 1; j < ry; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        int[] start = new int[]{startX, startY};
        que.offer(start);
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == endX && y == endY) {
                return visited[x][y] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                if (map[nx][ny] != 1 || check[nx][ny]) continue;
                
                check[nx][ny] = true;
                visited[nx][ny] = visited[x][y] + 1;
                que.offer(new int[]{nx, ny});
            }
        }
        return 0;
    }
}