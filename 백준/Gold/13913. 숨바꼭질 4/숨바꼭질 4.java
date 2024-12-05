import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        shortestTime(N, K);
    }
    
    public static void shortestTime(int N, int K) {
        Deque<int[]> deque = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] parent = new int[100001];
        
        deque.add(new int[]{N, 0});
        visited[N] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int location = current[0];
            int time = current[1];
            
            if (location == K) {
                System.out.println(time);
                
                List<Integer> path = new ArrayList<>();
                for (int i = location; i != N; i = parent[i]) {
                    path.add(i);
                }
                path.add(N);
                Collections.reverse(path);
                
                for(int p : path) {
                    System.out.print(p + " ");
                }
                return;
            }
            
            int[] nextLocations = {location + 1, location - 1, 2 * location};
            for (int next : nextLocations) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = location;
                    deque.add(new int[]{next, time + 1});
                }
            }
        }
    }
}