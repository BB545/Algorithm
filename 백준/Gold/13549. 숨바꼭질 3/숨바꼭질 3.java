import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        System.out.println(shortestTime(N, K));
    }
    
    public static int shortestTime(int N, int K) {
        Deque<Integer> deque = new LinkedList<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        deque.add(N);
        dist[N] = 0;
        
        while(!deque.isEmpty()) {
            int current = deque.poll();
            
            int[] nextLocations = {2 * current, current + 1, current - 1};
            for (int i = 0; i < 3; i++) {
                int next = nextLocations[i];
                
                if (next >= 0 && next <= 100000) {
                    int newTime = dist[current] + (i == 0 ? 0 : 1);
                    
                    if (newTime < dist[next]) {
                        dist[next] = newTime;
                        if (i == 0) {
                            deque.addFirst(next);
                        } else {
                            deque.addLast(next);
                        }
                    }
                }
            }
        }
        return dist[K];
    }
}