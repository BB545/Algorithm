import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static int max = 0;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][][] tetrominoEtc = {
        {{0, 0}, {-1, 0}, {0, -1}, {0, 1}},
        {{0, 0}, {-1, 0}, {0, 1}, {1, 0}},
        {{0, 0}, {0, -1}, {0, 1}, {1, 0}},
        {{0, 0}, {0, -1}, {-1, 0}, {1, 0}},
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkEtc(i, j);
            }
        }
        
        System.out.println(max);
    }
    
    public static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], cnt + 1);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static void checkEtc(int x, int y) {
        for (int[][] tetromino : tetrominoEtc) {
            int sum = 0;
            boolean isValid = true;
        
            for(int[] tetro : tetromino) {
                int nx = x + tetro[0];
                int ny = y + tetro[1];
            
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }
                sum += map[nx][ny];
            }
            
            if (isValid) {
                max = Math.max(max, sum);
            }
        }
    }
}