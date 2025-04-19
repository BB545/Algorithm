import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(shortestTime(N, K));
    }
    
    public static int shortestTime(int N, int K) {
        int max = 100000;
        boolean[] visited = new boolean[max + 1];
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{N, 0});
        visited[N] = true;
        
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int position = current[0];
            int time = current[1];
            
            if (position == K) {
                return time;
            }
            
            int[] nextPosition = {position - 1, position + 1, 2 * position};
            for (int next : nextPosition) {
                if (next >= 0 && next <= max && !visited[next]) {
                    visited[next] = true;
                    que.add(new int[]{next, time + 1});
                }
            }
        }
        
        return -1;
    }
}