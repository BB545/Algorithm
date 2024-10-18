import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
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