import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int maxSum = 0;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int[][][] tetromino = {
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
        {{0, 1}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                checkTetromino(i, j);
            }
        }
        
        System.out.println(maxSum);
    }
    
    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static void checkTetromino(int x, int y) {
        for (int[][] shape : tetromino) {
            int sum = 0;
            boolean isValid = true;
            
            for (int[] s : shape) {
                int nx = x + s[0];
                int ny = y + s[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    sum += board[nx][ny];
                } else {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}