import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> directions = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int appleX = sc.nextInt() - 1;
            int appleY = sc.nextInt() - 1;
            board[appleX][appleY] = 1;
        }
        
        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            directions.put(X, C);
        }
        
        System.out.println(simulate());
    }
    
    public static int simulate() {
        int time = 0;
        int dir = 0;
        
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 2;
        
        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                break;
            }
            
            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else if (board[nx][ny] == 0) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }
            
            if (directions.containsKey(time)) {
                char turn = directions.get(time);
                
                if (turn == 'L') {
                    dir = (dir + 3) % 4;
                } else if (turn == 'D') {
                    dir = (dir + 1) % 4;
                }
            }
        }
        
        return time;
    }
}