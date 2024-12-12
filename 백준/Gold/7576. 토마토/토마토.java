import java.io.*;
import java.util.*;

class Main {
    static int[][] box;
    static int M, N;
    static int[][] days;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        days = new int[N][M]; // 날짜 기록
        
        Queue<int[]> que = new LinkedList<>(); // 초기 상태 익은 토마토 위치 저장
        boolean allRipe = true;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                
                if (box[i][j] == 1) {
                    que.add(new int[]{i, j});
                    days[i][j] = 0;
                } else if (box[i][j] == 0) {
                    allRipe = false;
                } else {
                    days[i][j] = -1; // 초기값 -1
                }
            }
        }
        
        if (allRipe) {
            System.out.println(0);
            return;
        }
        
        bfs(que);
        
        int maxDays = 0;
        boolean possible = true;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    possible = false;
                }
                maxDays = Math.max(maxDays, days[i][j]);
            }
        }
        
        System.out.println(possible ? maxDays : -1);
    }
    
    public static void bfs(Queue<int[]> que) {
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    days[nx][ny] = days[cx][cy] + 1;
                    que.add(new int[]{nx, ny});
                }
            }
        }
    }
}