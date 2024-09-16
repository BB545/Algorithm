import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        boolean[][] visited = new boolean[101][101];
        for (int[] point : rectangle) {
            int lx = point[0] * 2;
            int ly = point[1] * 2;
            int rx = point[2] * 2;
            int ry = point[3] * 2;
            
            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    visited[i][j] = true;
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
                    visited[i][j] = false;
                }
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        int[] start = new int[]{startX, startY};
        que.offer(start);
        
        int realD = 0;
        int arriveD = 0;
        int min = 0;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            visited[x][y] = false;
            
            if (x == endX && y == endY) {
                arriveD = realD / 2;
                min = Math.min(arriveD, (realD - arriveD) / 2);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (2 <= nx && nx <= 100 && 2 <= ny && ny <= 100 && visited[nx][ny]) {
                    que.offer(new int[]{nx, ny});
                }
            }
            realD++;
        }
        return min;
    }
}