import java.util.*;

public class Main {
    static char[][] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        int minChanges = Integer.MAX_VALUE;
        
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minChanges = Math.min(minChanges, getMinChanges(i, j));
            }
        }
        
        System.out.println(minChanges);
    }
    
    public static int getMinChanges(int x, int y) {
        int whiteStart = 0;
        int blackStart = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[x + i][y + j] != 'W') whiteStart++;
                    if (board[x + i][y + j] != 'B') blackStart++;
                } else {
                    if (board[x + i][y + j] != 'B') whiteStart++;
                    if (board[x + i][y + j] != 'W') blackStart++;
                }
            }
        }
        
        return Math.min(whiteStart, blackStart);
    }
}