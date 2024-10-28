import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    
    static int[][][] tetris = {
        {{0,0}, {0,1}, {0,2}, {0,3}},
		{{0,0}, {1,0}, {2,0}, {3,0}},
		{{0,0}, {0,1}, {1,1}, {1,2}},
		{{0,0}, {1,0}, {1,-1}, {2,-1}},
		{{0,0}, {0,1}, {0,2}, {1,2}},
		{{0,0}, {1,0}, {2,0}, {2,-1}},
		{{0,0}, {1,0}, {1,1}, {1,2}},
		{{0,0}, {0,1}, {1,0}, {2,0}},
		{{0,0}, {0,1}, {0,2}, {1,1}},
		{{0,0}, {1,0}, {1,-1}, {2,0}},
		{{0,0}, {1,0}, {1,-1}, {1,1}},
		{{0,0}, {1,0}, {1,1}, {2,0}},
		{{0,0}, {1,0}, {0,1}, {1,1}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int testCase = 1;
        
        while (true) {
            N = Integer.parseInt(br.readLine().trim());
            if (N == 0) break;
            
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken().trim());
                }
            }
            
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxSum = checkTetris(i, j, maxSum);
                }
            }
            
            sb.append(testCase++).append(". ").append(maxSum).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static int checkTetris(int x, int y, int maxSum) {        
        for (int[][] shape : tetris) {
            int sum = 0;
            boolean isValid = true;
            
            for (int[] s : shape) {
                int nx = x + s[0];
                int ny = y + s[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
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
        return maxSum;
    }
}