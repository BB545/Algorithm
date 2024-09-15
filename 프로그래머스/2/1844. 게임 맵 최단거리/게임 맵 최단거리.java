import java.util.*;

class Solution {
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int lr = maps.length;
        int lc = maps[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        
        int[][] visited = new int[lr][lc];
        visited[0][0] = 1;
        
        while(!que.isEmpty()) {
            int[] p = que.poll();
            int r = p[0], c = p[1];
            
            if (r == lr - 1 && c == lc - 1) return visited[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < lr && 0 <= nc && nc < lc && maps[nr][nc] == 1 && visited[nr][nc] == 0) {
                    que.offer(new int[]{nr, nc});
                    visited[nr][nc] = visited[r][c] + 1;
                }
            }
        }
        
        return -1;
    }
}