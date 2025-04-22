import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; // 상좌우하 (우선순위에 맞게)
    static int[] dy = {0, -1, 1, 0};
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sx = 0, sy = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0; // 아기 상어 위치 초기화
                }
            }
        }

        while (true) {
            int[] result = bfs(sx, sy);
            if (result == null) break;

            int nx = result[0], ny = result[1], dist = result[2];
            time += dist;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }

            map[nx][ny] = 0;
            sx = nx;
            sy = ny;
        }

        System.out.println(time);
    }

    public static int[] bfs(int sx, int sy) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        List<int[]> candidates = new ArrayList<>();

        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int d = dist[x][y];

            if (d > minDist) break;

            if (map[x][y] > 0 && map[x][y] < sharkSize) {
                candidates.add(new int[]{x, y, d});
                minDist = d;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != -1) continue;
                if (map[nx][ny] > sharkSize) continue;

                dist[nx][ny] = d + 1;
                q.add(new int[]{nx, ny});
            }
        }

        if (candidates.isEmpty()) return null;

        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 위쪽 우선
            return Integer.compare(a[1], b[1]); // 왼쪽 우선
        });

        return candidates.get(0);
    }
}
