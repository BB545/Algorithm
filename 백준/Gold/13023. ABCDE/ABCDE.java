import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().trim().split(" ");
            int a = Integer.parseInt(command[0]);
            int b = Integer.parseInt(command[1]);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 0)) {
                System.out.println(1);
                return;
            }
        }
        
        System.out.println(0);
    }
    
    public static boolean dfs(int node, int depth) {
        if (depth == 4) {
            return true;
        }
        
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                if (dfs(next, depth + 1)) {
                    return true;
                }
            }
        }
        
        visited[node] = false;
        return false;
    }
}