import java.util.*;

class Main {
    static int[][] board;
    static int N, M;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }
        
        System.out.println(countWall(0, 0));
    }
    
    public static int countWall(int X, int Y) {
        Deque<int[]> deque = new LinkedList<>();
        int[][] wall = new int[N][M]; // 벽 부수기 횟수 저장 (방문 여부도 동시 관리)
        
        for(int[] w : wall) {
            Arrays.fill(w, Integer.MAX_VALUE); // 최댓값으로 초기화
        }
        
        wall[X][Y] = 0;
        deque.add(new int[]{X, Y});
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == N - 1 && y == M - 1) {
                return wall[x][y];
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int newWall = wall[x][y] + board[nx][ny];
                    
                    if (newWall < wall[nx][ny]) { // 아직 방문x = wall[nx][ny]는 초기화된 최댓값
                        wall[nx][ny] = newWall;
                        if (board[nx][ny] == 1) {
                            deque.addLast(new int[]{nx, ny});
                        } else {
                            deque.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }
}