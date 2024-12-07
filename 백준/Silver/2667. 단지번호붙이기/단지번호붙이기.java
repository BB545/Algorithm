import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String row = br.readLine().trim();
            
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        
        List<Integer> homes = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    homes.add(bfs(i, j));
                }
            }
        }
        
        System.out.println(homes.size());
        Collections.sort(homes);
        for (int h : homes) {
            System.out.println(h);
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;
        
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            cnt++;
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}